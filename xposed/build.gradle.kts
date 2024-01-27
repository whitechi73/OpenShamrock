plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.devtools.ksp") version "1.9.21-1.0.15"
    kotlin("plugin.serialization") version "1.9.21"
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
    compileOnly ("de.robv.android.xposed:api:82")
    compileOnly (project(":qqinterface"))

    implementation(project(":protobuf"))
    implementation(project(":annotations"))
    ksp(project(":processor"))

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    DEPENDENCY_ANDROIDX.forEach {
        implementation(it)
    }
    implementation(DEPENDENCY_JAVA_WEBSOCKET)
    implementation(DEPENDENCY_PROTOBUF)
    implementation(DEPENDENCY_JSON5K)

    implementation(room("runtime"))
    kapt(room("compiler"))
    implementation(room("ktx"))

    implementation(kotlinx("io-jvm", "0.1.16"))
    implementation(kotlinx("serialization-protobuf", "1.6.2"))

    implementation(ktor("server", "core"))
    implementation(ktor("server", "host-common"))
    implementation(ktor("server", "status-pages"))
    implementation(ktor("server", "netty"))
    implementation(ktor("server", "content-negotiation"))
    implementation(ktor("client", "core"))
    implementation(ktor("client", "content-negotiation"))
    implementation(ktor("client", "cio"))
    implementation(ktor("serialization", "kotlinx-json"))
    implementation(ktor("network", "tls-certificates"))

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.06.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
}


