package com.example.sink

import com.example.common.entity.MessageDto
import com.example.common.entity.MessageRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.Message

@SpringBootApplication(scanBasePackages = ["com.example.common", "com.example.sink"])
class SinkApplication

fun main(args: Array<String>) {
    runApplication<SinkApplication>(*args)
}

@Configuration
class ConsumerConfiguration(
    private val messageRepository: MessageRepository,
    private val objectMapper: ObjectMapper
) {

    @Bean
    fun consumer(): (Message<String>) -> Unit {
        return { message ->
            run {
                val messageDto = objectMapper.readValue(message.payload, MessageDto::class.java)
                messageRepository.save(messageDto.toEntity())
                println("consuming message: headers: ${message.headers}, payload: ${message.payload}")
            }
        }
    }
}
