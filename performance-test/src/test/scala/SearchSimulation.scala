import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SearchSimulation extends Simulation {

  private val baseUrl = "http://localhost:8080"
  private val endpoint = "/searches"
  private val contentType = "application/json"
  private val requestCount = 4

  private val simUsers = System.getProperty("SIM_USERS", "1").toInt

  private val httpConf = http
    .baseURL(baseUrl)
    .acceptHeader("application/json;charset=UTF-8")

  private val addSearchTest = repeat(requestCount) {
    exec(http("add-search-test")
      .post(endpoint)
      .header("Content-Type", contentType)
      .body(StringBody(
        s"""
            {
             "name": "test",
             "query": "something"
             }
         """.stripMargin
      )).check(status.is(200)))
  }
  private val scn = scenario("BootLoadSimulation")
    .exec(addSearchTest)

  setUp(scn.inject(atOnceUsers(simUsers))).protocols(httpConf)
}
