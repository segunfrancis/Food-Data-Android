include(":usecase")
include(":domain")
include(":feature:details")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Food Data Android"
include(":app")
include(":data:remote")
