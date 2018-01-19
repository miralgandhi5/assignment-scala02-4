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
    def getTotalCommission[T <: Commission :ClassTag](listOfCommission: List[T]): String = {
      listOfCommission.totalDisplayCommission

    }

    private implicit class ListExtension[T <: Commission :ClassTag](listOfCommission: List[T]) extends CommissionDisplay {
      override def totalDisplayCommission: String = {
        if (listOfCommission.isEmpty) {
          "Empty list"
        }

        else {
          listOfCommission match {

            case _: List[ClientSideCommission @unchecked] if classTag[T] == classTag[ClientSideCommission] => val res = listOfCommission.map(_.value).sum
              s"The total client commission is $res"
            case _: List[StreetSideCommission @unchecked] if classTag[T] == classTag[StreetSideCommission] => val res = listOfCommission.map(_.value).sum
              s"The total street commission is $res"
            case _: List[Commission @unchecked] if classTag[T] == classTag[Commission] => val res = listOfCommission.map(_.value).sum
              s"The total commission is $res"

          }

        }
      }
    }

  }

}

