@file:Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = uri("https://kotlin.bintray.com/kotlinx"))
    }
}

rootProject.name = "MoviesApp"

include(":movies-app")
include(":movies-data")
include(":movies-domain")
