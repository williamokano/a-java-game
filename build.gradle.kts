plugins {
    id("application")
}

group = "okano.dev.java.agame"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass = "okano.dev.java.agame.main.Main"
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}