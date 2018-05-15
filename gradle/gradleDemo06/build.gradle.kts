/*plugins{
    application
    java
    war
}*/

buildscript {
    repositories {
        maven {
            setUrl("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("gradle.plugin.com.xenoterracide.gradle:pluginbundle:0.1.21")
    }
}

apply{
    plugin("com.xenoterracide.gradle.java-lib")
}

/*
plugins {
    id("com.xenoterracide.gradle.java-lib") version("0.1.21")
}*/
