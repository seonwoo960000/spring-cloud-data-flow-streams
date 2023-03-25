package com.example.source

import com.example.common.entity.MessageDto
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import kotlin.random.Random


@SpringBootApplication
class SourceApplication

fun main(args: Array<String>) {
    runApplication<SourceApplication>(*args)
}

@Configuration
class SourceConfiguration {
    companion object {
        val random = Random(1234)
        val objectMapper: ObjectMapper = ObjectMapper().registerModule(
            KotlinModule.Builder()
                .withReflectionCacheSize(512)
                .configure(KotlinFeature.NullToEmptyCollection, false)
                .configure(KotlinFeature.NullToEmptyMap, false)
                .configure(KotlinFeature.NullIsSameAsDefault, false)
                .configure(KotlinFeature.SingletonSupport, false)
                .configure(KotlinFeature.StrictNullChecks, false)
                .build()
        )
    }

    @Bean
    fun producer(): () -> Message<String> {
        return {
            println("producing message, ${objectMapper.writeValueAsString(
                MessageDto(
                    message = "message ${random.nextInt()}",
                    description = "description ${random.nextInt()}"
                )
            )}")
            MessageBuilder.withPayload(
                objectMapper.writeValueAsString(
                    MessageDto(
                        message = "message ${random.nextInt()}",
                        description = "description ${random.nextInt()}"
                    )
                )
            ).build()
        }
    }
}
