package me.anelfer.tictactoebackend.rest.controller

import me.anelfer.tictactoebackend.rest.service.SessionService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/v1/sessions")
class SessionController(val sessionService: SessionService) {

    @PostMapping("")
    fun createSession() : UUID {
        return sessionService.createSession()
    }
}