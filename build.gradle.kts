plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.seleniumhq.selenium:selenium-java:4.15.0'
    implementation 'org.testng:testng:7.8.0'
}

test {
    useJUnitPlatform()
}