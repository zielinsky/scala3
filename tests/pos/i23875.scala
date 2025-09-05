object Foo {
  override def equals(that : Any) = that match {
    case _: this.type => true
    case _            => false
  }
}

@main def main =
  val _ = Foo.equals(Foo)
