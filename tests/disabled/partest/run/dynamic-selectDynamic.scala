import scala.tools.partest.DirectTest

object Test extends DirectTest {

  override def extraSettings: String =
    s"-usejavacp -Xprint-pos -Vprint:typer -Yrangepos -Ystop-after:typer -d ${testOutput.path}"

  override def code = """
    object X {
      val d = new D
      d.field
    }
  """.trim

  override def show(): Unit = {
    Console.withErr(System.out) {
      compile()
    }
  }
}

import language.dynamics
class D extends Dynamic {
  def selectDynamic(name: String) = ???
}
