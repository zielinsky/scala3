import java.util.concurrent.TimeUnit
import scala.concurrent.duration.{FiniteDuration, NANOSECONDS as NANO_SD, MICROSECONDS as MICRO_SD,
  MILLISECONDS as MILLI_SD, SECONDS as SEC_SD, MINUTES as MIN_SD, HOURS as HR_SD, DAYS as DAY_SD}

object Test1:
  final val NANOSECONDS = TimeUnit.NANOSECONDS
  final val MICROSECONDS = TimeUnit.MICROSECONDS
  final val MILLISECONDS = TimeUnit.MILLISECONDS
  final val SECONDS = TimeUnit.SECONDS
  final val MINUTES = TimeUnit.MINUTES
  final val HOURS = TimeUnit.HOURS
  final val DAYS = TimeUnit.DAYS

  def test(unit: TimeUnit) = unit match
    case NANOSECONDS =>
    case MICROSECONDS =>
    case MILLISECONDS =>
    case SECONDS =>
    case MINUTES =>
    case HOURS =>
    case DAYS =>

object Test2:
  final val NANO = TimeUnit.NANOSECONDS
  final val MICRO = TimeUnit.MICROSECONDS
  final val MILLI = TimeUnit.MILLISECONDS
  final val SEC = TimeUnit.SECONDS
  final val MIN = TimeUnit.MINUTES
  final val HR = TimeUnit.HOURS
  final val DAY = TimeUnit.DAYS

  def test(unit: TimeUnit) = unit match
    case NANO =>
    case MICRO =>
    case MILLI =>
    case SEC =>
    case MIN =>
    case HR =>
    case DAY =>

object Test3:
  final val NANO = TimeUnit.NANOSECONDS
  final val MICRO = TimeUnit.MICROSECONDS
  final val MILLI = TimeUnit.MILLISECONDS

  def test(unit: TimeUnit) = unit match
    case NANO =>
    case MICRO =>
    case MILLI =>
    case TimeUnit.SECONDS =>
    case TimeUnit.MINUTES =>
    case TimeUnit.HOURS =>
    case TimeUnit.DAYS =>

object Test4:
  object Duration:
    export TimeUnit.{NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS, DAYS}

  import Duration.*

  def test(unit: TimeUnit) = unit match
    case NANOSECONDS =>
    case MICROSECONDS =>
    case MILLISECONDS =>
    case SECONDS =>
    case MINUTES =>
    case HOURS =>
    case DAYS =>

object Test5:
  def test(unit: TimeUnit) = unit match
    case TimeUnit.NANOSECONDS =>
    case TimeUnit.MICROSECONDS =>
    case TimeUnit.MILLISECONDS =>
    case TimeUnit.SECONDS =>
    case TimeUnit.MINUTES =>
    case TimeUnit.HOURS =>
    case TimeUnit.DAYS =>

object Test6:
  def test(duration: FiniteDuration) = duration.unit match
    case NANO_SD =>
    case MICRO_SD =>
    case MILLI_SD =>
    case SEC_SD =>
    case MIN_SD =>
    case HR_SD =>
    case DAY_SD =>
