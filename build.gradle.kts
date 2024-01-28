plugins {
    kotlin("jvm") version "1.9.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-scripting-jvm:1.9.22")
    implementation("org.jetbrains.kotlin:kotlin-scripting-common:1.9.22")
    implementation("org.jetbrains.kotlin:kotlin-scripting-jvm-host:1.9.22")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}