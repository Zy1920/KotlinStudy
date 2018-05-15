import org.gradle.api.internal.file.pattern.PatternMatcherFactory.compile
import org.gradle.kotlin.dsl.kotlin

//负责当前模块的配置
plugins{
    application
    kotlin("jvm")
}
repositories{
    mavenCentral()
}
dependencies{
    compile(kotlin("stdlib"))
    compile(project(":Core"))
}
