package me.anelfer.tictactoebackend.game

class Game(val size: Int = 3, val status: GameStatus) {
    val board: Array<Array<GameFigure>> = Array(size) { Array(size) { GameFigure.EMPTY } }

    fun checkGame(): Boolean {
        val n = board.size

        // Check rows and columns
        for (i in 0 until n) {
            var rowWin = true
            var colWin = true
            for (j in 1 until n) {
                if (board[i][j] != board[i][0] || board[i][0] == GameFigure.EMPTY) {
                    rowWin = false
                }
                if (board[j][i] != board[0][i] || board[0][i] == GameFigure.EMPTY) {
                    colWin = false
                }
            }
            if (rowWin || colWin) {
                return true
            }
        }

        // Check main diagonal
        var mainDiagonalWin = true
        for (i in 1 until n) {
            if (board[i][i] != board[0][0] || board[0][0] == GameFigure.EMPTY) {
                mainDiagonalWin = false
                break
            }
        }
        if (mainDiagonalWin) {
            return true
        }

        // Check anti-diagonal
        var antiDiagonalWin = true
        for (i in 1 until n) {
            if (board[i][n - i - 1] != board[0][n - 1] || board[0][n - 1] == GameFigure.EMPTY) {
                antiDiagonalWin = false
                break
            }
        }
        return antiDiagonalWin
    }

    fun place(index: Int, gameFigure: GameFigure) : Boolean {
        val x: Int = index / board[0].size
        val y: Int = index % board[1].size

        val value = board[x][y]
        if (value != GameFigure.EMPTY) return false
        board[x][y] = gameFigure
        return true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Game

        if (size != other.size) return false
        if (!board.contentDeepEquals(other.board)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = size
        result = 31 * result + board.contentDeepHashCode()
        return result
    }
}
