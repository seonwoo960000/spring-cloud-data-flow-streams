package com.example.common.entity

import jakarta.persistence.*

@Entity
@Table(name = "message")
class Message(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    @Column(name = "message", length = 1000)
    var message: String = "default message",
    @Column(name = "description", length = 1000)
    var description: String = "default description",
) {
}
