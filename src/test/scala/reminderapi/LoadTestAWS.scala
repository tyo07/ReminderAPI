package reminderapi

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

class LoadTest extends Simulation {

  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl("domainbasepath/api/activity/get")

  object ReminderApiResource {
    val get: ChainBuilder = exec(http("ReminderApi")
      .get("/"))
  }

  val myScenario: ScenarioBuilder = scenario("RampUpUsers")
    .exec(ReminderApiResource.get)

  setUp(myScenario.inject(
    incrementUsersPerSec(50)
      .times(5)
      .eachLevelLasting(5 seconds)
      .separatedByRampsLasting(5 seconds)
      .startingFrom(5)
  )).protocols(httpProtocol)
    .assertions(global.successfulRequests.percent.is(100))
}
