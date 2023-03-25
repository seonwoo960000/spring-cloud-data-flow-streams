package com.example.common.entity

data class MessageDto(
    val message: String,
    val description: String
) {
    fun toEntity(): Message {
        return Message(
            message = message,
            description = description
        )
    }
}
