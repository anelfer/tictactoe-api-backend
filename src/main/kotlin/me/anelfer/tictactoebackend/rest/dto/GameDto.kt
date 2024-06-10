package me.anelfer.tictactoebackend.rest.dto

import me.anelfer.tictactoebackend.game.GameFigure
import java.util.UUID

data class GameDto(
    val gameUID: UUID,
    val index: Int,
    val gameFigure: GameFigure
)
