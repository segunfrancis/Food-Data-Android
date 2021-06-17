object Dependency {
    const val CORE_KTX = "androidx.core:core-ktx:${Version.coreKtx}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${Version.appcompat}"
    const val MATERIAL = "com.google.android.material:material:${Version.material}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Version.constraint}"
    const val COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coreKtx}"
    const val LIFECYCLE_EXTENSION = "androidx.lifecycle:lifecycle-extensions:${Version.lifecycle}"
    const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle_unstable}"
    const val LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle_unstable}"
    const val NAVIGATION_FRAGMENT = "androidx.fragment:fragment-ktx:${Version.fragment}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
    const val KOTLIN_STANDARD_LIBRARY = "org.jetbrains.kotlin:kotlin-stdlib:${Version.gradlePlugin}"
    const val LEGACY_SUPPORT = "androidx.legacy:legacy-support-v4:${Version.legacy}"

    object Network {
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
        const val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
        const val OK_HTTP_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Version.okHttp}"
    }

    object DI {
        const val DAGGER = "com.google.dagger:dagger:${Version.dagger}"
        const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:${Version.dagger}"
    }

    object Log {
        const val TIMBER = "com.jakewharton.timber:timber:${Version.timber}"
    }

    object Test {
        const val J_UNIT = "junit:junit:${Version.jUnit}"
        const val J_UNIT_EXT = "androidx.test.ext:junit:${Version.junitExt}"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Version.espresso}"
        const val TEST_ANNOTATION = "androidx.annotation:annotation:${Version.testAnnotation}"
    }
}
