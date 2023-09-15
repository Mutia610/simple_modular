import org.gradle.api.JavaVersion

object Config {
    const val androidMinSdkVersion = 21
    const val versionCode = 1
    const val versionName = "0.0.1"
    const val applicationId = "com.mutia.simple_modular"
    const val androidCompileSdkVersion = 32
    const val androidTargetSdkVersion = 32
    val javaVersion = JavaVersion.VERSION_11
    const val jvmTarget = "11"
    const val buildTools = "30.0.2"
    const val testInstrumentationRunner = "com.mutia.base.application.TestAppJUnitRunner"
    const val proguardFiles = "consumer-rules.pro"
}