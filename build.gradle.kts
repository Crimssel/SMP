plugins {
    kotlin("jvm") version "1.3.72"
}

group = requireNotNull(properties["pluginName"]) { "Group is undefined in properties" }
version = requireNotNull(properties["pluginVersion"]) { "Version is undefined in properties" }

repositories {
    mavenCentral()
    maven(url = "https://papermc.io/repo/repository/maven-public/") //paper
    maven(url = "https://repo.dmulloy2.net/nexus/repository/public/") //protocollib
    maven(url = "https://jitpack.io/") //tap, psychic
    maven(url = "https://repo.dmulloy2.net/nexus/repository/public/") //ProtocolLib
}

dependencies {
    implementation(kotlin("stdlib-jdk8")) //kotlin
    implementation("junit:junit:4.12") //junit
    implementation("io.papermc.paper:paper-api:1.19.1-R0.1-SNAPSHOT") //paper
    implementation("com.comphenix.protocol:ProtocolLib:4.5.1")
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
    }
    javadoc {
        options.encoding = "UTF-8"
    }
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    processResources {
        filesMatching("**/*.yml") {
            expand(project.properties)
        }
    }
}