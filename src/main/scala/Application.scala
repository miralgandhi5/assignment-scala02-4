import Operation.{ClientSideCommission, Commission, StreetSideCommission, TotalCommission}
import org.apache.log4j.Logger

object Application extends App {
  val log: Logger = Logger.getLogger(this.getClass)
  val value = 10
  val one: Commission = StreetSideCommission(value)
  val two: Commission = ClientSideCommission(value)
  val three: Commission = StreetSideCommission(value)
  val clientOne: ClientSideCommission = ClientSideCommission(value)
  val clientTwo: ClientSideCommission = ClientSideCommission(value)
  val clientThree: ClientSideCommission = ClientSideCommission(value)
  val streetCne: StreetSideCommission = StreetSideCommission(value)
  val streetTwo: StreetSideCommission = StreetSideCommission(value)
  val streetThree: StreetSideCommission = StreetSideCommission(value)
  val demo = new TotalCommission
  log.info(demo.getTotalCommission(List(one, two, three)))
  log.info(demo.getTotalCommission(List(clientOne, clientTwo, clientThree)))
  log.info(demo.getTotalCommission(List(streetCne, streetTwo, streetThree)))


}
