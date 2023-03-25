package com.example.source

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
    }

    @Bean
    fun producer(): () -> Message<String> {
        println("producing message")
        return { MessageBuilder.withPayload("From source module! ${random.nextInt()}").build() }
    }
}
