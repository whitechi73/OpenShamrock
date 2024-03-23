val DEPENDENCY_ANDROIDX = arrayOf(
    "androidx.core:core-ktx:1.12.0",
    "androidx.appcompat:appcompat:1.6.1",
    "com.google.android.material:material:1.11.0",
    "androidx.exifinterface:exifinterface:1.3.7",
    "androidx.lifecycle:lifecycle-runtime-ktx:2.6.1",
    "androidx.activity:activity-compose:1.7.2",
)

fun room(name: String) = "androidx.room:room-$name:${Versions.roomVersion}"

fun kotlinx(name: String, version: String) = "org.jetbrains.kotlinx:kotlinx-$name:$version"

fun ktor(target: String, name: String): String {
    return "io.ktor:ktor-$target-$name:${Versions.ktorVersion}"
}

fun grpc(name: String, version: String) = "io.grpc:grpc-$name:$version"

object Versions {
    const val roomVersion = "2.5.0"
    const val ktorVersion = "2.3.3"
}