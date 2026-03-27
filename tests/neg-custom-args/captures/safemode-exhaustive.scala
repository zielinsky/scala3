import language.experimental.safe

object Test:

  sealed trait Color
  case object Red extends Color
  case object Green extends Color
  case object Blue extends Color

  def f(c: Color): Int = c match // error
    case Red => 1
    case Green => 2
    // Blue is missing

  def g(c: Color): Int = c match // ok
    case Red => 1
    case Green => 2
    case Blue => 3

  def h(x: Any): String = x match // error
    case i: Int => s"int: $i"
    case s: String => s"str: $s"
    // no wildcard, Any is not exhaustively matched
