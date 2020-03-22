sealed trait LoginError
case object InvalidPassword extends LoginError
case object UserNotFound    extends LoginError
case object PasswordLocked  extends LoginError

case class User(id: Long, name: String, password: String)

object LoginService {
  def main(args: Array[String]): Unit = {
    LoginService.login(name= "taro", password = "example") match {
      case Right(user) => println(s"id = ${user.id} name = ${user.name}")
      case Left(InvalidPassword) => println(s"Invalid pass...")
      case Left(UserNotFound) => println(s"not found...")
      case Left(PasswordLocked) =>println(s"locked...")
    }
  }

  def login(name: String, password: String): Either[LoginError, User] = {
    (name, password) match {
      case ("taro", "example") => Right(User(1, name, password))
      case ("taro", _)         => Left(InvalidPassword)
      //case (_, "example")      => Left(UserNotFound)
      case (_, _)             => Left(UserNotFound)
    }
  }
}
