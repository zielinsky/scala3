//> using options -Werror

type TidyNonEmpty[T <: NonEmptyTuple] = T match {
  case Tuple1[a] => a
  case _         => T
}

def tidyNonEmpty[T <: NonEmptyTuple](tuple: T): TidyNonEmpty[T] = tuple match {
  case tuple1: Tuple1[a] => tuple1._1
  case _                 => tuple
}