plugins {
    java
}

group = "net.azisaba"
version = "1.0.0-SNAPSHOT"

java.toolchain.languageVersion.set(JavaLanguageVersion.of(8))

repositories {
    mavenCentral()
    maven { url = uri("https://hub.spigotmc.org/nexus/content/groups/public/") }
}

dependencies {
    // spigot-api
    compileOnly("org.spigotmc:spigot-api:1.12.2-R0.1-SNAPSHOT")
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
    }

    processResources {
        from(sourceSets.main.get().resources.srcDirs) {
            include("**")
            val tokenReplacementMap = mapOf(
                "VERSION" to project.version
            )
            filter<org.apache.tools.ant.filters.ReplaceTokens>("tokens" to tokenReplacementMap)
        }
        filteringCharset = "UTF-8"
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
    }
}
