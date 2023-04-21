package com.example.tictac

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.CheckBox
import android.widget.EditText
import android.util.Log

fun clearfield(field: Array<IntArray>){
    for (i in field.indices){
        for (j in field.indices){
            field[i][j] = 0
        }
    }
}

fun checkdraw(field: Array<IntArray>): Boolean{
    var draw = true
    for (i in field.indices){
        for (j in field.indices){
            if (field[i][j] == 0){
            draw = false
            }
        }
    }
    return draw
}

fun computermove(field: Array<IntArray>): Int{
    var number = 0
    for (i in field.indices){
        for (j in field.indices){
            number += 1
            if (field[i][j] == 0){
                return number
            }
        }
    }
    return 0
}

fun checkwinners(field: Array<IntArray>): Int{

    for (i in 0..2) {

        if (field[i][0] == field[i][1] && field[i][0] == field[i][2] && field[i][0] > 0) {
            return field[i][0]
        }

        if (field[0][i] == field[1][i] && field[0][i] == field[2][i] && field[0][i] > 0) {
            return field[0][i]
        }
    }

    if (field[0][0] == field[1][1] && field[0][0] == field[2][2] && field[0][0] > 0) {
        return field[0][0]
    }

    if (field[0][2] == field[1][1] && field[0][2] == field[2][0] && field[0][2] > 0) {
        return field[0][2]
    }

    return 0

}

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var player = 0
        var computer = 0
        var gameover = 0
        var playername1 = "Player 1"
        var playername2 = "Player 2"
        val field = Array(3) {IntArray(3)}
        clearfield(field)

        setContentView(R.layout.activity_main)
        val newgame = findViewById<Button>(R.id.newgame)
        val textView = findViewById<TextView>(R.id.TextView)

        val bt1 = findViewById<Button>(R.id.Button1)
        val bt2 = findViewById<Button>(R.id.Button2)
        val bt3 = findViewById<Button>(R.id.Button3)
        val bt4 = findViewById<Button>(R.id.Button4)
        val bt5 = findViewById<Button>(R.id.Button5)
        val bt6 = findViewById<Button>(R.id.Button6)
        val bt7 = findViewById<Button>(R.id.Button7)
        val bt8 = findViewById<Button>(R.id.Button8)
        val bt9 = findViewById<Button>(R.id.Button9)
        val chk = findViewById<CheckBox>(R.id.checkBox)
        val name1 = findViewById<EditText>(R.id.playername1)
        val name2 = findViewById<EditText>(R.id.playername2)

        val buttons = arrayOf(bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9)

        newgame.setOnClickListener {
            clearfield(field)
            player = 0
            gameover = 0
            bt1.text = "."
            bt2.text = "."
            bt3.text = "."
            bt4.text = "."
            bt5.text = "."
            bt6.text = "."
            bt7.text = "."
            bt8.text = "."
            bt9.text = "."

            if (name1.text.isNotEmpty()){
                playername1 = name1.text.toString()
            }

            if (name2.text.isNotEmpty()){
                playername2 = name2.text.toString()
            }

            textView.text = playername1 + " turn"

            if (chk.isChecked){
                computer = 1
                playername2 = "Computer"
            }
            else {
                computer = 0
                if (name2.text.isNotEmpty()) {
                    playername2 = name2.text.toString()
                }
            }

        }

        bt1.setOnClickListener{
            if (gameover == 0) {
                if (field[0][0] < 1) {
                    if (player == 0) {
                        bt1.text = "X"
                    } else {
                        bt1.text = "O"
                    }
                    field[0][0] = 1 + player
                    player = 1 - player
                    if (checkwinners(field) == 1) {
                        textView.text = playername1 + " Wins"
                        gameover = 1
                    } else if (checkwinners(field) == 2) {
                        textView.text = playername2 + " Wins"
                        gameover = 1
                    } else if (checkdraw(field)) {
                        textView.text = "It's a draw"
                        gameover = 1
                    } else {
                        if (player == 1) {
                            if (computer == 1) {
                                var buttonpress = computermove(field)
                                if (buttonpress >= 0) {
                                    val makemove = buttons[buttonpress - 1]
                                    makemove.performClick()
                                }
                            } else {
                                textView.text = playername2 + " turn"
                            }
                        } else {
                            textView.text = playername1 + " turn"
                        }
                    }
                }
            }
        }

        bt2.setOnClickListener{
            if (gameover == 0) {
                if (field[0][1] < 1) {
                    if (player == 0) {
                        bt2.text = "X"
                    } else {
                        bt2.text = "O"
                    }
                    field[0][1] = 1 + player
                    player = 1 - player
                    if (checkwinners(field) == 1) {
                        textView.text = playername1 + " Wins"
                        gameover = 1
                    } else if (checkwinners(field) == 2) {
                        textView.text = playername2 + " Wins"
                        gameover = 1
                    } else if (checkdraw(field)) {
                        textView.text = "It's a draw"
                        gameover = 1
                    } else {
                        if (player == 1) {
                            if (computer == 1) {
                                var buttonpress = computermove(field)
                                if (buttonpress >= 0) {
                                    val makemove = buttons[buttonpress - 1]
                                    makemove.performClick()
                                }
                            } else {
                                textView.text = playername2 + " turn"
                            }
                        } else {
                            textView.text = playername1 + " turn"
                        }
                    }
                }
            }
        }

        bt3.setOnClickListener{
            if (gameover == 0) {
                if (field[0][2] < 1) {
                    if (player == 0) {
                        bt3.text = "X"
                    } else {
                        bt3.text = "O"
                    }
                    field[0][2] = 1 + player
                    player = 1 - player
                    if (checkwinners(field) == 1) {
                        textView.text = playername1 + " Wins"
                        gameover = 1
                    } else if (checkwinners(field) == 2) {
                        textView.text = playername2 + " Wins"
                        gameover = 1
                    } else if (checkdraw(field)) {
                        textView.text = "It's a draw"
                        gameover = 1
                    } else {
                        if (player == 1) {
                            if (computer == 1) {
                                var buttonpress = computermove(field)
                                if (buttonpress >= 0) {
                                    val makemove = buttons[buttonpress - 1]
                                    makemove.performClick()
                                }
                            } else {
                                textView.text = playername2 + " turn"
                            }
                        } else {
                            textView.text = playername1 + " turn"
                        }
                    }
                }
            }
        }

        bt4.setOnClickListener{
            if (gameover == 0) {
                if (field[1][0] < 1) {
                    if (player == 0) {
                        bt4.text = "X"
                    } else {
                        bt4.text = "O"
                    }
                    field[1][0] = 1 + player
                    player = 1 - player
                    if (checkwinners(field) == 1) {
                        textView.text = playername1 + " Wins"
                        gameover = 1
                    } else if (checkwinners(field) == 2) {
                        textView.text = playername2 + " Wins"
                        gameover = 1
                    } else if (checkdraw(field)) {
                        textView.text = "It's a draw"
                        gameover = 1
                    } else {
                        if (player == 1) {
                            if (computer == 1) {
                                var buttonpress = computermove(field)
                                if (buttonpress >= 0) {
                                    val makemove = buttons[buttonpress - 1]
                                    makemove.performClick()
                                }
                            } else {
                                textView.text = playername2 + " turn"
                            }
                        } else {
                            textView.text = playername1 + " turn"
                        }
                    }
                }
            }
        }

        bt5.setOnClickListener{
            if (gameover == 0) {
                if (field[1][1] < 1) {
                    if (player == 0) {
                        bt5.text = "X"
                    } else {
                        bt5.text = "O"
                    }
                    field[1][1] = 1 + player
                    player = 1 - player
                    if (checkwinners(field) == 1) {
                        textView.text = playername1 + " Wins"
                        gameover = 1
                    } else if (checkwinners(field) == 2) {
                        textView.text = playername2 + " Wins"
                        gameover = 1
                    } else if (checkdraw(field)) {
                        textView.text = "It's a draw"
                        gameover = 1
                    } else {
                        if (player == 1) {
                            if (computer == 1) {
                                var buttonpress = computermove(field)
                                if (buttonpress >= 0) {
                                    val makemove = buttons[buttonpress - 1]
                                    makemove.performClick()
                                }
                            } else {
                                textView.text = playername2 + " turn"
                            }
                        } else {
                            textView.text = playername1 + " turn"
                        }
                    }
                }
            }
        }

        bt6.setOnClickListener{
            if (gameover == 0) {
                if (field[1][2] < 1) {
                    if (player == 0) {
                        bt6.text = "X"
                    } else {
                        bt6.text = "O"
                    }
                    field[1][2] = 1 + player
                    player = 1 - player
                    if (checkwinners(field) == 1) {
                        textView.text = playername1 + " Wins"
                        gameover = 1
                    } else if (checkwinners(field) == 2) {
                        textView.text = playername2 + " Wins"
                        gameover = 1
                    } else if (checkdraw(field)) {
                        textView.text = "It's a draw"
                        gameover = 1
                    } else {
                        if (player == 1) {
                            if (computer == 1) {
                                var buttonpress = computermove(field)
                                if (buttonpress >= 0) {
                                    val makemove = buttons[buttonpress - 1]
                                    makemove.performClick()
                                }
                            } else {
                                textView.text = playername2 + " turn"
                            }
                        } else {
                            textView.text = playername1 + " turn"
                        }
                    }
                }
            }
        }

        bt7.setOnClickListener{
            if (gameover == 0) {
                if (field[2][0] < 1) {
                    if (player == 0) {
                        bt7.text = "X"
                    } else {
                        bt7.text = "O"
                    }
                    field[2][0] = 1 + player
                    player = 1 - player
                    if (checkwinners(field) == 1) {
                        textView.text = playername1 + " Wins"
                        gameover = 1
                    } else if (checkwinners(field) == 2) {
                        textView.text = playername2 + " Wins"
                        gameover = 1
                    } else if (checkdraw(field)) {
                        textView.text = "It's a draw"
                        gameover = 1
                    } else {
                        if (player == 1) {
                            if (computer == 1) {
                                var buttonpress = computermove(field)
                                if (buttonpress >= 0) {
                                    val makemove = buttons[buttonpress - 1]
                                    makemove.performClick()
                                }
                            } else {
                                textView.text = playername2 + " turn"
                            }
                        } else {
                            textView.text = playername1 + " turn"
                        }
                    }
                }
            }
        }

        bt8.setOnClickListener{
            if (gameover == 0) {
                if (field[2][1] < 1) {
                    if (player == 0) {
                        bt8.text = "X"
                    } else {
                        bt8.text = "O"
                    }
                    field[2][1] = 1 + player
                    player = 1 - player
                    if (checkwinners(field) == 1) {
                        textView.text = playername1 + " Wins"
                        gameover = 1
                    } else if (checkwinners(field) == 2) {
                        textView.text = playername2 + " Wins"
                        gameover = 1
                    } else if (checkdraw(field)) {
                        textView.text = "It's a draw"
                        gameover = 1
                    } else {
                        if (player == 1) {
                            if (computer == 1) {
                                var buttonpress = computermove(field)
                                if (buttonpress >= 0) {
                                    val makemove = buttons[buttonpress - 1]
                                    makemove.performClick()
                                }
                            } else {
                                textView.text = playername2 + " turn"
                            }
                        } else {
                            textView.text = playername1 + " turn"
                        }
                    }
                }
            }
        }

        bt9.setOnClickListener {
            if (gameover == 0) {
                if (field[2][2] < 1) {
                    if (player == 0) {
                        bt9.text = "X"
                    } else {
                        bt9.text = "O"
                    }
                    field[2][2] = 1 + player
                    player = 1 - player
                    if (checkwinners(field) == 1) {
                        textView.text = playername1 + " Wins"
                        gameover = 1
                    } else if (checkwinners(field) == 2) {
                        textView.text = playername2 + " Wins"
                        gameover = 1
                    } else if (checkdraw(field)) {
                        textView.text = "It's a draw"
                        gameover = 1
                    } else {
                        if (player == 1) {
                            if (computer == 1) {
                                var buttonpress = computermove(field)
                                if (buttonpress >= 0) {
                                    val makemove = buttons[buttonpress - 1]
                                    makemove.performClick()
                                }
                            } else {
                                textView.text = playername2 + " turn"
                            }
                        } else {
                            textView.text = playername1 + " turn"
                        }
                    }
                }

            }
        }

    }
}