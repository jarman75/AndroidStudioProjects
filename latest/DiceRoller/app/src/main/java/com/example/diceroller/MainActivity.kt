package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton : Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countButton : Button = findViewById(R.id.count_up)
        countButton.setOnClickListener { countUp() }
    }

    private fun countUp() {
        Toast.makeText(this, "countUp button clicked",
            Toast.LENGTH_SHORT).show()

        val resultText : TextView = findViewById(R.id.result_text)
        if (resultText.text.toString() == "Hello World!")
            resultText.text = "1"
        else if (resultText.text.toString() != "6")
            resultText.text = (resultText.text.toString().toShort() + 1).toString()


    }

    private fun rollDice(){
        Toast.makeText(this, "rollDice button clicked",
            Toast.LENGTH_SHORT).show()

        val randomInt = (1..6).random()

        val resultText : TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
    }
}