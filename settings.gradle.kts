pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        maven (url = "https://maven.pkg.jetbrains.space/public/p/ktor/eap")
        maven (url = "https://dl.bintray.com/kotlin/kotlin-eap" )
        maven (url = "https://api.xposed.info/" )
        maven (url = "https://jitpack.io" )
    }
}

buildscript {
    repositories {
        mavenCentral()
        maven {
            url = uri("https://storage.googleapis.com/r8-releases/raw")
        }
    }
    dependencies {
        classpath("com.android.tools:r8:8.2.47")
    }
}

rootProject.name = "Shamrock"
include(
    ":app",
    ":xposed",
    ":qqinterface"
)
include(":protobuf")
include(":processor")
include(":annotations")
