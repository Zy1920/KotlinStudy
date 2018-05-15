buildscript {
    repositories {
        maven {
            setUrl("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.2.41")
    }
}
allprojects{
    apply{
        plugin("org.jetbrains.kotlin.jvm")
    }
}

