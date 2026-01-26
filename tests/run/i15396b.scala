// Test multiple enum values in inner enum
class Outer extends Serializable {
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
  val outer = Outer()

  // Test serializing companion
  val color = serializeDeserialize(outer.Color)
  assert(color != null, "companion should not be null")
  assert(color.Red != null, "Red should not be null")
  assert(color.Green != null, "Green should not be null")
  assert(color.Blue != null, "Blue should not be null")

  // Test ordinals are correct
  assert(color.Red.ordinal == 0, s"Red ordinal should be 0, got ${color.Red.ordinal}")
  assert(color.Green.ordinal == 1, s"Green ordinal should be 1, got ${color.Green.ordinal}")
  assert(color.Blue.ordinal == 2, s"Blue ordinal should be 2, got ${color.Blue.ordinal}")

  // Test values array
  assert(color.values.length == 3, "should have 3 values")

  // Test fromOrdinal works
  assert(color.fromOrdinal(0) == color.Red)
  assert(color.fromOrdinal(1) == color.Green)
  assert(color.fromOrdinal(2) == color.Blue)

  // Test valueOf works
  assert(color.valueOf("Red") == color.Red)
  assert(color.valueOf("Green") == color.Green)
  assert(color.valueOf("Blue") == color.Blue)
