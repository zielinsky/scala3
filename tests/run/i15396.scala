class Foo extends Serializable {
  enum Bar {
    case A
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
  val foo = Foo()
  // Test that serialization/deserialization of inner enum companion doesn't crash (issue #15396)
  // Before the fix, this would throw NoSuchElementException during deserialization
  val bar = serializeDeserialize(foo.Bar)
  assert(bar != null)
  assert(bar.A != null)
  assert(bar.A.ordinal == 0)