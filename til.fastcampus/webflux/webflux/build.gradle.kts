import org.gradle.api.internal.tasks.compile.CompileJavaBuildOperationType

plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.netty:netty-all:4.1.113.Final")
    implementation("org.springframework.boot:spring-boot-starter-webflux:3.3.3")
    implementation("org.springframework.boot:spring-boot-starter-actuator:3.3.3")
    implementation("org.springframework.boot:spring-boot-starter-mustache:3.3.3")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc:3.3.3")
    implementation("org.springframework.security:spring-security-core:6.3.3")
    implementation("io.projectreactor:reactor-tools:3.6.10")
    implementation("io.r2dbc:r2dbc-h2:1.0.0.RELEASE")
    implementation("com.h2database:h2:2.3.232")

    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testCompileOnly("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.30")
}

tasks.test {
    useJUnitPlatform()
}