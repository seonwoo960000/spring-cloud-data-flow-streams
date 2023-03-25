package com.example.source

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SourceApplication

fun main(args: Array<String>) {
    runApplication<SourceApplication>(*args)
}
