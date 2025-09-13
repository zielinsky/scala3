object Test:
  def main(args: Array[String]): Unit =
    // Test that BigInt can be matched against integral literals without "unreachable case" warnings
    def testBigIntPatterns(x: BigInt): String = x match
      case 1 => "one"
      case 2L => "two"
      case 42 => "answer"
      case _ => "other"
    
    // Test different integral types  
    assert(testBigIntPatterns(BigInt(1)) == "one")
    assert(testBigIntPatterns(BigInt(2)) == "two") 
    assert(testBigIntPatterns(BigInt(42)) == "answer")
    assert(testBigIntPatterns(BigInt(100)) == "other")
    
    // Test edge cases
    def testEdgeCases(x: BigInt): String = x match
      case 0 => "zero"
      case -1 => "negative one"
      case 2147483647 => "max int"    // Int.MaxValue
      case 9223372036854775807L => "max long"  // Long.MaxValue 
      case _ => "other"
      
    assert(testEdgeCases(BigInt(0)) == "zero")
    assert(testEdgeCases(BigInt(-1)) == "negative one")
    assert(testEdgeCases(BigInt(Int.MaxValue)) == "max int")
    assert(testEdgeCases(BigInt(Long.MaxValue)) == "max long")
    assert(testEdgeCases(BigInt("999999999999999999999")) == "other")
    