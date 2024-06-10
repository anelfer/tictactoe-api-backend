package me.anelfer.tictactoebackend.rest.dto

import me.anelfer.tictactoebackend.game.GameStatus
import java.rmi.server.UID
import java.util.UUID

data class StatusDto(
    val gameUID: UUID,
    val status: GameStatus
)
