trait T[E <: java.lang.Enum[E]] extends java.lang.Enum[E]

enum MyEnum extends T[MyEnum] { // error
  case A, B
}
