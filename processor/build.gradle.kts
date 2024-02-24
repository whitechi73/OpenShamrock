plugins {
    kotlin("jvm")
    id("com.google.devtools.ksp") version "1.9.22-1.0.17"
    kotlin("plugin.serialization") version "1.9.22"
}

ksp {
    arg("autoserviceKsp.verify", "true")
    arg("autoserviceKsp.verbose", "true")
}

dependencies {
    implementation(project(":annotations"))
    implementation("com.google.auto.service:auto-service-annotations:1.1.1")
    implementation("com.google.devtools.ksp:symbol-processing-api:1.9.21-1.0.15")
    implementation("com.squareup:kotlinpoet:1.14.2")

    implementation(DEPENDENCY_PROTOBUF)
    implementation(kotlinx("serialization-protobuf", "1.6.2"))

    ksp("dev.zacsweers.autoservice:auto-service-ksp:1.1.0")
}