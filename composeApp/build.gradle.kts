import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)

        }
    }
    
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation("io.ktor:ktor-client-okhttp:3.0.0")
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
//            implementation("io.ktor:ktor-client-okhttp:3.0.0")
            // Ktor client core
            implementation("io.ktor:ktor-client-core:3.0.0")
            implementation("io.ktor:ktor-client-content-negotiation:3.0.0")
            implementation("io.ktor:ktor-serialization-kotlinx-json:3.0.0")

            // JSON serialization
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")

            // DateTime and UUID support
            implementation("com.benasher44:uuid:0.8.4")

            // Coroutine support (for ViewModel/Repository)
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
            // Date & time handling
            implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.1")

            // UUID generation
            implementation("com.benasher44:uuid:0.8.4")
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            implementation(libs.navigation.compose)
        }
        commonTest.dependencies {
            implementation("io.ktor:ktor-client-darwin:3.0.0")
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.kug.payirthekkam"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.kug.payirthekkam"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.4")
}

