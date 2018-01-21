import scala.reflect.{ClassTag, classTag}

object Operation {

  private sealed trait CommissionDisplay {
    def totalDisplayCommission: String
  }

  abstract class Commission() {
    val value: Int
  }

  case class ClientSideCommission(override val value: Int) extends Commission {}

  case class StreetSideCommission(override val value: Int) extends Commission {}

  class TotalCommission {
    def getTotalCommission[T <: Commission : ClassTag](listOfCommission: List[T]): String = {
      listOfCommission.totalDisplayCommission

    }

    private implicit class ListExtension[T <: Commission : ClassTag](listOfCommission: List[T]) extends CommissionDisplay {
      override def totalDisplayCommission: String = {

        listOfCommission match {

          case _ if classTag[T] == classTag[ClientSideCommission] => val res = listOfCommission.map(_.value).sum
            s"The total client commission is $res"
          case _ if classTag[T] == classTag[StreetSideCommission] => val res = listOfCommission.map(_.value).sum
            s"The total street commission is $res"
          case _ if classTag[T] == classTag[Commission] => val res = listOfCommission.map(_.value).sum
            s"The total commission is $res"

        }

      }
    }

  }

}

