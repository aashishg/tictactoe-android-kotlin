package com.aashiapps.tictactoe

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val buttons = Array<Array<Button>>(3) { arrayOfNulls(3) }

    private val player1Turn = true
    private var roundCount: Int = 0

    private val player1Points: Int = 0
    private val player2Points: Int = 0

    private var textViewPlayer1: TextView? = null
    private var textViewPlayer2: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewPlayer1 = findViewById(R.id.text_view_p1)
        textViewPlayer2 = findViewById(R.id.text_view_p2)

        for (i in 0..2) {
            for (j in 0..2) {
                val buttonID = "button_$i$j"
                val resID = resources.getIdentifier(buttonID, "id",)
                buttons[i][j] = findViewById(resID)
                buttons[i][j].setOnClickListener(this)

            }
        }

        val buttonReset = findViewById<Button>(R.id.button_reset)
        buttonReset.setOnClickListener { }
    }

    fun onClick(v: View) {
        if ((v as Button).text.toString() != "") {
            return
        }
        if (player1Turn) {
            v.text = "X"
        } else {
            v.text = "O"
        }

        roundCount++
    }

    private fun checkForWin(): Boolean {
        val field = Array<Array<String>>(3) { arrayOfNulls(3) }
        for (i in 0..2) {
            for (j in 0..2) {
                field[i][j] = buttons[i][j].text.toString()

            }
        }

        for (i in 0..2) {
            if (field[i][0] == field[i][1]
                && field[i][0] == field[i][2]
                && field[i][0] != ""
            ) {
                return true
            }
        }
        for (i in 0..2) {
            if (field[i][0] == field[i][1]
                && field[i][0] == field[i][2]
                && field[i][0] != ""
            ) {
                return true
            }
        }

    }

}
