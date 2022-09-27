package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var diceImage : ImageView
    private lateinit var diceImage2 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val clearButton: Button = findViewById(R.id.clear_button)
        clearButton.setOnClickListener { clearDice() }

        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)

    }

    private fun clearDice(){
        diceImage.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)
    }

    private fun rollDice(){

        val randomInt = (1..6).random()
        val randomInt2 = (1..6).random()
        val total = randomInt+randomInt2

        Toast.makeText(this.diceImage.context, "It's $total !!",
            Toast.LENGTH_SHORT).show()

        diceImage.setImageResource(getImage(randomInt))
        diceImage2.setImageResource(getImage(randomInt2))
    }

    private fun getImage(randomInt: Int) : Int {
        return when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}