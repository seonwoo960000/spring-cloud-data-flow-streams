// let subprojects inherit all dependencies
subprojects {
    dependencyManagement {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:2022.0.1")
        }
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")

        implementation("org.springframework.cloud:spring-cloud-stream")
        implementation("org.springframework.cloud:spring-cloud-stream-binder-kafka")
        implementation("org.springframework.kafka:spring-kafka")
        implementation("org.springframework.cloud:spring-cloud-function-kotlin")

        runtimeOnly("com.h2database:h2")
        testImplementation("org.springframework.boot:spring-boot-starter-test")

        testImplementation("org.springframework.cloud:spring-cloud-stream")
        testImplementation("org.springframework.kafka:spring-kafka-test")
    }
}
