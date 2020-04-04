trait Additive[A] {
  def plus(a: A, b:A): A
  def zero: A
}

def sum[A](lst: List[A])(implicit m: Additive[A]): A = {
  lst.foldLeft(m.zero)((x,y) => m.plus(x,y))
}
implicit object StringAdditive extends Additive[String]{
  def plus(a: String, b: String): String = a + b
  def zero: String = ""
}

implicit object IntAdditive extends Additive[Int] {
  def plus(a: Int, b: Int): Int = a + b
  def zero: Int = 0
}
sum(List(1,2,3))
sum(List("aa", "cc", "done"))


val add = (x: Int, y: Int) => x*y
add(2,3)

def addCurry(x: Int)(y: Int): Int = {
  x+y
}
addCurry(100)(2)

//Main.series(3)

val option: Option[AnyVal] = Option(1)