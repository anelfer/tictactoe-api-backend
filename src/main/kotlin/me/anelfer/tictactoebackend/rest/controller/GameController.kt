package me.anelfer.tictactoebackend.rest.controller

import me.anelfer.tictactoebackend.game.GameFigure
import me.anelfer.tictactoebackend.rest.dto.GameDto
import me.anelfer.tictactoebackend.rest.dto.SessionDto
import me.anelfer.tictactoebackend.rest.service.GameService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/v1/game")
class GameController(val gameService: GameService) {

    @GetMapping
    fun getGameBoard(sessionUID: UUID): Array<Array<GameFigure>>? {
        return gameService.getBoard(sessionUID)
    }

    @GetMapping("/check")
    fun checkGame(sessionUID: UUID): Boolean {
        return gameService.checkGame(sessionUID)
    }

    @PostMapping
    fun startGame(@RequestBody sessionDto: SessionDto) {
        gameService.startGame(sessionDto.session)
    }

    @PostMapping("/place")
    fun placeFigure(@RequestBody gameDto: GameDto): Boolean {
        return gameService.placeFigure(gameDto)
    }
}