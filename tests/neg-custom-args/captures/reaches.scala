import caps.use;
import caps.consume
class File:
  def write(): Unit = ???

def usingFile[T](f: File^ => T): T = ???

type Proc = () => Unit

class Ref[T](init: T):
  private var x: T = init
  def get: T = x
  def set(y: T) = { x = y }

def runAll0(@use xs: List[Proc]): Unit =
  var cur: List[() ->{xs*} Unit] = xs
  while cur.nonEmpty do
    val next: () ->{xs*} Unit = cur.head
    next()
    cur = cur.tail: List[() ->{xs*} Unit]

  usingFile: f => // error
    cur = (() => f.write()) :: Nil

def runAll1(@use xs: List[Proc]): Unit =
  val cur = Ref[List[() ->{xs*} Unit]](xs)  // OK, by revised VAR
  while cur.get.nonEmpty do
    val next: () ->{xs*} Unit = cur.get.head
    next()
    cur.set(cur.get.tail: List[() ->{xs*} Unit])

  usingFile: f => // error
    cur.set:
      (() => f.write()) :: Nil

def runAll2(@consume xs: List[Proc]): Unit =
  var cur: List[Proc] = xs
  while cur.nonEmpty do
    val next: () => Unit = cur.head   // error
    next()
    cur = cur.tail

def runAll3(xs: List[Proc]): Unit =
  val cur = Ref[List[Proc]](xs) // error
  while cur.get.nonEmpty do
    val next: () => Unit = cur.get.head // error
    next()
    cur.set(cur.get.tail: List[Proc]) // error

class Id[-A,  +B >: A]():
  def apply(a: A): B = a

def test =
  val id: Id[Proc, Proc] = new Id[Proc, () -> Unit] // error
  usingFile: f =>
    id(() => f.write()) // was error

def attack2 =
  val id: File^ -> File^ = x => x // error
    // val id: File^ -> File^{fresh}

  val leaked = usingFile[File^{id*}]: f => // now ok
    val f1: File^{id*} = id(f)
    f1

def attack3 =
  val id: (x: File^) -> File^ = x => x // error
    // val id: File^ -> EX C.File^C

  val leaked = usingFile[File^{id*}]: f => // error
    val f1: File^{id*} = id(f)
    f1

class List[+A]:
  def head: A = ???
  def tail: List[A] = ???
  def map[B](f: A => B): List[B] = ???
  def nonEmpty: Boolean = ???

extension [A](x: A) def :: (xs: List[A]): List[A] = ???

object Nil extends List[Nothing]

def compose1[A, B, C](f: A => B, g: B => C): A ->{f, g} C =
  z => g(f(z))

def mapCompose[A](ps: List[(A => A, A => A)]): List[A ->{ps*} A] =
  ps.map((x, y) => compose1(x, y)) // error

def mapCompose2[A](@use ps: List[(A => A, A => A)]): List[A ->{ps*} A] =
  ps.map((x, y) => compose1(x, y)) // error
