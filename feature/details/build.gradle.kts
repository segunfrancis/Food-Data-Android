plugins {
    id("com.android.dynamic-feature")
    id("kotlin-android")
}

android {
    //compileSdk = Version.targetSdk
    buildToolsVersion = Version.buildToolsVersion

    defaultConfig {
        applicationId = "com.segunfrancis.details"
        minSdk = Version.minSdk
        targetSdk = Version.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(":app"))
    implementation(Dependency.KOTLIN_STANDARD_LIBRARY)
    implementation(Dependency.CORE_KTX)
    testImplementation(Dependency.Test.J_UNIT)
    androidTestImplementation(Dependency.Test.J_UNIT_EXT)
    androidTestImplementation(Dependency.Test.ESPRESSO_CORE)
    androidTestImplementation(Dependency.Test.TEST_ANNOTATION)
}