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

package scala

import scala.language.`2.13`

/** This class represents uninitialized variable/value errors.
 */
// TODO: remove
@deprecated("will be removed in a future release", since = "2.12.7")
final class UninitializedError extends RuntimeException("uninitialized value")
