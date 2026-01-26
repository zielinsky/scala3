// Test inner enum serialization limitations - pattern matching does NOT work
// after deserialization because it uses reference equality (eq).
// This test documents the workaround: use ordinal-based matching.
class Wrapper extends Serializable {
  enum Direction {
    case North, South, East, West

    // Workaround: use ordinal-based matching instead of case matching
    def describeByOrdinal: String = this.ordinal match {
      case 0 => "up"
      case 1 => "down"
      case 2 => "right"
      case 3 => "left"
    }
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
  val wrapper = Wrapper()

  // Serialize companion
  val dir = serializeDeserialize(wrapper.Direction)

  // Ordinal-based matching works on deserialized enum values
  assert(dir.North.describeByOrdinal == "up")
  assert(dir.South.describeByOrdinal == "down")
  assert(dir.East.describeByOrdinal == "right")
  assert(dir.West.describeByOrdinal == "left")

  // Serialize individual values
  val north = serializeDeserialize(wrapper.Direction.North)
  val south = serializeDeserialize(wrapper.Direction.South)

  // Ordinal-based matching works on individually deserialized values too
  assert(north.describeByOrdinal == "up")
  assert(south.describeByOrdinal == "down")
