// Test serializing individual enum values (not companion)
class Container extends Serializable {
  enum Status {
    case Pending, Active, Done
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
  val container = Container()

  // Serialize individual enum values
  val pending = serializeDeserialize(container.Status.Pending)
  val active = serializeDeserialize(container.Status.Active)
  val done = serializeDeserialize(container.Status.Done)

  // Verify they deserialized correctly
  assert(pending != null, "pending should not be null")
  assert(active != null, "active should not be null")
  assert(done != null, "done should not be null")

  // Verify ordinals
  assert(pending.ordinal == 0, s"pending ordinal should be 0, got ${pending.ordinal}")
  assert(active.ordinal == 1, s"active ordinal should be 1, got ${active.ordinal}")
  assert(done.ordinal == 2, s"done ordinal should be 2, got ${done.ordinal}")

  // Verify toString
  assert(pending.toString == "Pending", s"expected 'Pending', got '${pending.toString}'")
  assert(active.toString == "Active", s"expected 'Active', got '${active.toString}'")
  assert(done.toString == "Done", s"expected 'Done', got '${done.toString}'")

  // Note: For inner enums, object identity is NOT preserved after deserialization
  // This is expected behavior - see #15396
  // assert(pending eq container.Status.Pending) // would fail
