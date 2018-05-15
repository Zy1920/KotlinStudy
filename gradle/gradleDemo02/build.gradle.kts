plugins{
    application
    kotlin("jvm")
}
application{
    mainClassName="TestKt"
}
repositories{
    mavenCentral()
}
dependencies{
    compile(kotlin("stdlib"))
}

