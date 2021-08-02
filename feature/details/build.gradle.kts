plugins {
    id("com.android.dynamic-feature")
    id("kotlin-android")
}

android {
    buildToolsVersion = Version.buildToolsVersion

    defaultConfig {
        applicationId = "com.segunfrancis.details"
        minSdk = Version.minSdk
        targetSdk = Version.targetSdk
        compileSdkVersion(Version.targetSdk)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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