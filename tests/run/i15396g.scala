// Test inner enum with class cases (parameterized)
class Container extends Serializable {
  enum Result {
    case Success(value: Int)
    case Failure(message: String)
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

  // Create class case instances
  val success = container.Result.Success(42)
  val failure = container.Result.Failure("error")

  // Serialize and deserialize
  val successDeserialized = serializeDeserialize(success)
  val failureDeserialized = serializeDeserialize(failure)

  // Verify values are preserved
  assert(successDeserialized != null)
  assert(failureDeserialized != null)

  // Note: Pattern matching and type tests with path-dependent types do NOT work
  // for inner enums after deserialization (same limitation as singleton cases).
  // This is a fundamental limitation of Java serialization + path-dependent types.

  // But we can access fields directly if we know the type
  assert(successDeserialized.isInstanceOf[container.Result.Success])
  assert(successDeserialized.asInstanceOf[container.Result.Success].value == 42)

  assert(failureDeserialized.isInstanceOf[container.Result.Failure])
  assert(failureDeserialized.asInstanceOf[container.Result.Failure].message == "error")

  // Ordinals
  assert(successDeserialized.ordinal == 0)
  assert(failureDeserialized.ordinal == 1)
