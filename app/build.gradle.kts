
plugins {
    alias(libs.plugins.jvm)
    application
    id("io.gitlab.arturbosch.detekt") version("1.23.3")
    id("com.diffplug.spotless") version "6.25.0"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation(libs.junit.jupiter.engine)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.3")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(19))
    }
}

spotless {
    kotlin {
        ktlint("1.1.1")
    }
}

detekt {
    toolVersion = "1.23.3"
}

val test = tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    reports {
        xml.required.set(true)
        html.required.set(true)
        txt.required.set(true)
        sarif.required.set(true)
        md.required.set(true)
    }
}

tasks.register("initProject") {
    group = "Custom"
    description = "Init task for the project, run this after cloning"
    doLast {
        println("... Adding pre-commit hook")
        exec {
            commandLine("cp", "../.scripts/pre-commit", "../.git/hooks")
        }
        println("✅ Added Pre Commit Git Hook Script.")
    }
}
