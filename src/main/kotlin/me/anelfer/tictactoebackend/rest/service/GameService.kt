package me.anelfer.tictactoebackend.rest.service

import me.anelfer.tictactoebackend.game.Game
import me.anelfer.tictactoebackend.game.GameFigure
import me.anelfer.tictactoebackend.game.GameStatus
import me.anelfer.tictactoebackend.rest.dto.GameDto
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class GameService(val sessionService: SessionService) {

    private val games = mutableMapOf<UUID, Game>()

    fun startGame(gameUID: UUID) {
        val status = sessionService.getStatus(gameUID)
        if (status != GameStatus.CREATED) return //todo: fix
        games[gameUID] = Game(status = GameStatus.GAME_IN_PROGRESS)
    }

    fun placeFigure(gameDto: GameDto): Boolean {
        val game = games[gameDto.gameUID] ?: throw ResponseStatusException(HttpStatus.OK, "Game not found")
        return game.place(gameDto.index, gameDto.gameFigure)
    }

    fun getBoard(gameUUID: UUID): Array<Array<GameFigure>>? {
        return games[gameUUID]?.board
    }

    fun checkGame(gameUID: UUID): Boolean {
        return games[gameUID]?.checkGame() == true
    }
}