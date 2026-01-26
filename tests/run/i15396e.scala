// Test multiple outer instances with inner enums
class Session extends Serializable {
  enum State {
    case New, Running, Finished
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
  // Create two separate outer instances
  val session1 = Session()
  val session2 = Session()

  // Their enum companions are different objects
  assert(session1.State ne session2.State, "different sessions should have different State companions")

  // Serialize both companions
  val state1 = serializeDeserialize(session1.State)
  val state2 = serializeDeserialize(session2.State)

  // Both should work correctly
  assert(state1.New != null)
  assert(state2.New != null)
  assert(state1.New.ordinal == 0)
  assert(state2.New.ordinal == 0)

  // Deserialized companions are independent
  assert(state1 ne state2, "deserialized companions should be different objects")

  // Serialize the whole outer object
  val deserializedSession = serializeDeserialize(session1)
  assert(deserializedSession != null)
  assert(deserializedSession.State != null)
  assert(deserializedSession.State.New != null)
  assert(deserializedSession.State.Running.ordinal == 1)
  assert(deserializedSession.State.Finished.ordinal == 2)
