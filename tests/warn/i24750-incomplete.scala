import java.util.concurrent.TimeUnit

object Test1:
  import scala.concurrent.duration.*

  def incomplete(unit: TimeUnit) = unit match // error: match may not be exhaustive
    case NANOSECONDS =>
    case MICROSECONDS =>

object Test2:
  final val NANO = TimeUnit.NANOSECONDS
  final val MICRO = TimeUnit.MICROSECONDS

  def incomplete(unit: TimeUnit) = unit match // error: match may not be exhaustive
    case NANO =>
    case MICRO =>
