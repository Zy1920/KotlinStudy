group="com.itcast.coroutines"
version="1.0-SNAPSHOT"

plugins{
    java
    kotlin("jvm")
}
repositories{
    mavenCentral()
    jcenter()
}
dependencies{
    compile(kotlin("stdlib"))
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-core:0.22.5")
}
