import language.experimental.captureChecking

import caps.{use, consume}

  // ok
  def runOps(@use ops: List[() => Unit]): Unit =
    ops.foreach(op => op())

  // ok
  def delayedRunOps(@use ops: List[() => Unit]): () ->{ops*} Unit = // @use should not be necessary in the future
    () => runOps(ops)

  // unsound: impure operation pretended pure
  def delayedRunOps1(ops: List[() => Unit]): () ->{} Unit =
    () => // error
      val ops1 = ops
      runOps(ops1)

  // unsound: impure operation pretended pure
  def delayedRunOps2(@consume ops: List[() => Unit]): () ->{} Unit =
    () =>
      val ops1: List[() => Unit] = ops // error
      runOps(ops1)  // error

  // unsound: impure operation pretended pure
  def delayedRunOps3(ops: List[() => Unit]): () ->{} Unit =
    () => // error
      val ops1: List[() ->{ops*} Unit] = ops
      runOps(ops1)
