import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
}

group = "de.philgamer"
version = "1.0"

repositories {
    mavenCentral()
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }

}

dependencies {
    testImplementation(kotlin("test"))
    implementation("net.axay:kspigot:1.17.4")
    compileOnly("io.papermc.paper:paper-api:1.18-R0.1-SNAPSHOT")
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}