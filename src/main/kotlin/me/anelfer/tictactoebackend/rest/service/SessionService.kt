package me.anelfer.tictactoebackend.rest.service

import me.anelfer.tictactoebackend.game.GameStatus
import me.anelfer.tictactoebackend.rest.dto.StatusDto
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class SessionService {

    val sessions = mutableMapOf<UUID, GameStatus>()

    fun createSession(): UUID {
        val randomUUID = UUID.randomUUID()
        sessions[randomUUID] = GameStatus.CREATED
        return randomUUID
    }

    fun getStatus(uuid: UUID): GameStatus {
        return sessions[uuid] ?: throw ResponseStatusException(HttpStatus.OK, "Game not found")
    }

    fun changeGameStatus(statusDto: StatusDto) {
        sessions[statusDto.gameUID] = statusDto.status
    }
}