package me.anelfer.tictactoebackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TictactoeBackendApplication

fun main(args: Array<String>) {
    runApplication<TictactoeBackendApplication>(*args)
}
