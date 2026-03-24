val x: Any = 42
val y = x match
  case i: Int => s"int: $i"
  case s: String => s"str: $s"
  case _ => "other"