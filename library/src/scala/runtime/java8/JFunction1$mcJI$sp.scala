/*
 * Scala (https://www.scala-lang.org)
 *
 * Copyright EPFL and Lightbend, Inc. dba Akka
 *
 * Licensed under Apache License 2.0
 * (http://www.apache.org/licenses/LICENSE-2.0).
 *
 * See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 */

package scala.runtime.java8

import scala.language.`2.13`

@FunctionalInterface trait JFunction1$mcJI$sp extends Function1[Any, Any] with Serializable {
  def apply$mcJI$sp(v1: Int): Long
  override def apply(t: Any): Any = scala.runtime.BoxesRunTime.boxToLong(apply$mcJI$sp(scala.runtime.BoxesRunTime.unboxToInt(t)))
}
