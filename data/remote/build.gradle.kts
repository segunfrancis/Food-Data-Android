import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

fun getApiKey(): String {
    val keysProperties = Properties()
    keysProperties.load(project.rootProject.file("secret.properties").inputStream())
    return keysProperties.getProperty("API_KEY", "")
}

android {
    compileSdk = Version.targetSdk
    buildToolsVersion = Version.buildToolsVersion

    defaultConfig {
        minSdk = Version.minSdk
        targetSdk = Version.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        buildConfigField("String", "API_KEY", getApiKey())
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(Dependency.CORE_KTX)
    implementation(Dependency.APPCOMPAT)
    implementation(Dependency.COROUTINE)
    implementation(Dependency.DI.DAGGER)
    kapt(Dependency.DI.DAGGER_COMPILER)
    implementation(Dependency.Network.RETROFIT)
    implementation(Dependency.Network.RETROFIT_GSON)
    implementation(Dependency.Network.OK_HTTP_INTERCEPTOR)
    testImplementation(Dependency.Test.J_UNIT)
}
