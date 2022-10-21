pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Cartana Shopping"
include(":app")
include(":core:common")
include(":core:theme")
include(":core:network")
include(":core:database")
include(":core:data")
include(":core:model")
