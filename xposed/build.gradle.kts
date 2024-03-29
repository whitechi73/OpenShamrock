import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.devtools.ksp") version "1.9.22-1.0.17"
    kotlin("plugin.serialization") version "1.9.22"
}

android {
    namespace = "moe.fuqiuluo.xposed"
    compileSdk = 34

    defaultConfig {
        minSdk = 27

        consumerProguardFiles("consumer-rules.pro")
        @Suppress("UnstableApiUsage")
        externalNativeBuild {
            cmake {
                cppFlags += ""
            }
        }
    }

    buildFeatures {
        aidl = true
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }
}

kotlin {
    sourceSets.all {
        languageSettings {
            languageVersion = "2.0"
        }
    }
}

dependencies {
    compileOnly("de.robv.android.xposed:api:82")
    compileOnly(project(":qqinterface"))

    implementation(project(":kritor"))
    implementation(project(":protobuf"))
    implementation(project(":annotations"))
    ksp(project(":processor"))

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    DEPENDENCY_ANDROIDX.forEach {
        implementation(it)
    }

    implementation(room("runtime"))
    kapt(room("compiler"))
    implementation(room("ktx"))

    implementation(kotlinx("io-jvm", "0.1.16"))

    implementation(ktor("client", "core"))
    implementation(ktor("client", "okhttp"))
    implementation(ktor("serialization", "kotlinx-json"))

    implementation(grpc("protobuf", "1.62.2"))
    implementation(grpc("kotlin-stub", "1.4.1"))
    implementation(grpc("okhttp", "1.62.2"))

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.06.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
}

tasks.withType<KotlinCompile>().all {
    kotlinOptions {
        freeCompilerArgs = listOf("-opt-in=kotlin.RequiresOptIn")
    }
}
