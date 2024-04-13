package com.example.tests.data

data class Game(
    //player1
    var player1: String = "",
    //player2
    var player2: String = "",
    //winner
    var winner: String = "",
    //player1 score
    var player1Score: Int = 0,
    //player2 score
    var player2Score: Int = 0,
)