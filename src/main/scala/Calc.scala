class Calc {
  def sum(seq: Seq[Int]): Int = {
    seq.foldLeft(0)(_+_)
  }

  def div(num1: Int, num2: Int): Double = {
    if(num2 == 0) throw new ArithmeticException(" / by zero")
    num1.toDouble / num2.toDouble
  }

  def isPrime(n: Int): Boolean = {
    if(n < 2)false
    else !((2 to Math.sqrt(n).toInt) exists(n % _ == 0))
  }
}
