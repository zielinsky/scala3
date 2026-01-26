// Regression test: static enums should still work with object identity preserved
object StaticOuter {
  enum Color {
    case Red, Green, Blue
  }
}

def serializeDeserialize[T <: AnyRef](obj: T): T = {
  import java.io.*
  val buffer = new ByteArrayOutputStream
  val out = new ObjectOutputStream(buffer)
  out.writeObject(obj)
  val in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray))
  in.readObject.asInstanceOf[T]
}

@main def Test =
  import StaticOuter.Color
  import StaticOuter.Color.*
  
  // Static enum values should preserve object identity
  val red = serializeDeserialize(Red)
  val green = serializeDeserialize(Green)
  
  // Object identity IS preserved for static enums (via readResolve)
  assert(red eq Red, "static enum should preserve identity")
  assert(green eq Green, "static enum should preserve identity")
  
  // Pattern matching works
  val result = red match {
    case Red => "red"
    case Green => "green"
    case Blue => "blue"
  }
  assert(result == "red", s"pattern match failed, got $result")
  
  // Companion serialization
  val color = serializeDeserialize(Color)
  assert(color eq Color, "static companion should preserve identity")
