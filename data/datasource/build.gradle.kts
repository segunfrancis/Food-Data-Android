plugins {
    id("java-library")
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    implementation(project(":domain"))
    implementation(Dependency.KOTLIN_STANDARD_LIBRARY)
    implementation(Dependency.COROUTINE)
    implementation(Dependency.DI.INJECT)
}
