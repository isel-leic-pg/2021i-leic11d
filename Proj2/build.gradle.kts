plugins {
    kotlin("jvm") version "1.4.10"
}
group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    flatDir { dirs("libs") }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("pt.isel:CanvasLib-jvm:1.0.0")
}
