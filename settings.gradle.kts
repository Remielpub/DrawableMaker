pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }

    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
//        mavenLocal()
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "DrawableMaker"
include(":app")
include(":LibDrawableMaker")
include(":ModuleAAR")
