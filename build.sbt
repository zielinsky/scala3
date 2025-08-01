val scala3 = Build.scala3
val `scala3-nonbootstrapped` = Build.`scala3-nonbootstrapped`
val `scala3-bootstrapped` = Build.`scala3-bootstrapped`
val `scala3-bootstrapped-new` = Build.`scala3-bootstrapped-new`
val `scala3-interfaces` = Build.`scala3-interfaces`
val `scala3-compiler` = Build.`scala3-compiler`
val `scala3-compiler-nonbootstrapped` = Build.`scala3-compiler-nonbootstrapped`
val `scala3-compiler-bootstrapped-new` = Build.`scala3-compiler-bootstrapped-new`
val `scala3-compiler-bootstrapped` = Build.`scala3-compiler-bootstrapped`
val `scala-library-nonbootstrapped` = Build.`scala-library-nonbootstrapped`
val `scala3-library-nonbootstrapped` = Build.`scala3-library-nonbootstrapped`
val `scala-library-bootstrapped` = Build.`scala-library-bootstrapped`
val `scala3-library-bootstrapped-new` = Build.`scala3-library-bootstrapped-new`
val `scala3-library` = Build.`scala3-library`
val `scala3-library-bootstrapped` = Build.`scala3-library-bootstrapped`
val `scala3-library-bootstrappedJS` = Build.`scala3-library-bootstrappedJS`
val `scala3-sbt-bridge` = Build.`scala3-sbt-bridge`
val `scala3-sbt-bridge-bootstrapped` = Build.`scala3-sbt-bridge-bootstrapped`
val `scala3-sbt-bridge-nonbootstrapped` = Build.`scala3-sbt-bridge-nonbootstrapped`
val `scala3-sbt-bridge-tests` = Build.`scala3-sbt-bridge-tests`
val `scala3-staging` = Build.`scala3-staging`
val `scala3-staging-new` = Build.`scala3-staging-new`
val `scala3-tasty-inspector` = Build.`scala3-tasty-inspector`
val `scala3-tasty-inspector-new` = Build.`scala3-tasty-inspector-new`
val `scala3-language-server` = Build.`scala3-language-server`
val `scala3-bench` = Build.`scala3-bench`
val `scala3-bench-bootstrapped` = Build.`scala3-bench-bootstrapped`
val `scala3-bench-micro` = Build.`scala3-bench-micro`
val `scala2-library-bootstrapped` = Build.`scala2-library-bootstrapped`
val `scala2-library-tasty` = Build.`scala2-library-tasty`
val `scala2-library-cc` = Build.`scala2-library-cc`
val `scala2-library-cc-tasty` = Build.`scala2-library-cc-tasty`
val `tasty-core` = Build.`tasty-core`
val `tasty-core-nonbootstrapped` = Build.`tasty-core-nonbootstrapped`
val `tasty-core-bootstrapped-new` = Build.`tasty-core-bootstrapped-new`
val `tasty-core-bootstrapped` = Build.`tasty-core-bootstrapped`
val `tasty-core-scala2` = Build.`tasty-core-scala2`
val scaladoc = Build.scaladoc
val `scaladoc-testcases` = Build.`scaladoc-testcases`
val `scaladoc-js-common` = Build.`scaladoc-js-common`
val `scaladoc-js-main` = Build.`scaladoc-js-main`
val `scaladoc-js-contributors` = Build.`scaladoc-js-contributors`
val `scala3-bench-run` = Build.`scala3-bench-run`
val dist = Build.dist
val `dist-mac-x86_64` = Build.`dist-mac-x86_64`
val `dist-mac-aarch64` = Build.`dist-mac-aarch64`
val `dist-win-x86_64` = Build.`dist-win-x86_64`
val `dist-linux-x86_64` = Build.`dist-linux-x86_64`
val `dist-linux-aarch64` = Build.`dist-linux-aarch64`
val `community-build` = Build.`community-build`
val `sbt-community-build` = Build.`sbt-community-build`
val `scala3-presentation-compiler` = Build.`scala3-presentation-compiler`
val `scala3-presentation-compiler-testcases` = Build.`scala3-presentation-compiler-testcases`

val sjsSandbox = Build.sjsSandbox
val sjsJUnitTests = Build.sjsJUnitTests
val sjsCompilerTests = Build.sjsCompilerTests

val `sbt-test` = Build.`sbt-test`

inThisBuild(Build.thisBuildSettings)
inScope(Global)(Build.globalSettings)
