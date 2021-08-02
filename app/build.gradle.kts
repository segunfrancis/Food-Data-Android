plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    compileSdk = Version.targetSdk
    buildToolsVersion = Version.buildToolsVersion

    defaultConfig {
        applicationId = "com.segunfrancis.fooddataandroid"
        minSdk = Version.minSdk
        targetSdk = Version.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
    dynamicFeatures = mutableSetOf(":feature:details")
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data:remote"))
    implementation(project(":data:datasource"))
    implementation(Dependency.KOTLIN_STANDARD_LIBRARY)
    implementation(Dependency.CORE_KTX)
    implementation(Dependency.APPCOMPAT)
    implementation(Dependency.MATERIAL)
    implementation(Dependency.CONSTRAINT_LAYOUT)
    implementation(Dependency.LEGACY_SUPPORT)
    implementation(Dependency.COROUTINE)
    implementation(Dependency.LIFECYCLE_EXTENSION)
    implementation(Dependency.VIEWMODEL)
    implementation(Dependency.LIVEDATA)
    implementation(Dependency.FRAGMENT_KTX)
    implementation(Dependency.NAVIGATION_FRAGMENT_KTX)
    implementation(Dependency.NAVIGATION_UI)
    implementation(Dependency.Log.TIMBER)
    implementation(Dependency.DI.DAGGER)
    kapt(Dependency.DI.DAGGER_COMPILER)
    implementation(Dependency.Network.RETROFIT)
    implementation(Dependency.Network.RETROFIT_GSON)
    implementation(Dependency.Network.OK_HTTP_INTERCEPTOR)
    testImplementation(Dependency.Test.J_UNIT)
    androidTestImplementation(Dependency.Test.J_UNIT_EXT)
    androidTestImplementation(Dependency.Test.ESPRESSO_CORE)
}
