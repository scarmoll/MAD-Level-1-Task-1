package com.example.mymadlevel1task1attempt1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mymadlevel1task1attempt1.databinding.ActivityMainBinding
import kotlin.random.Random

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var currentValue = 1
    private var previousValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLower.setOnClickListener {
            guessLower()
        }

        binding.btnHigher.setOnClickListener {
            guessHigher()
        }

        binding.btnEqual.setOnClickListener {
            guessEqual()
        }
    }

    private fun throwDice() {
        previousValue = currentValue

        currentValue = Random.nextInt(1,7)

        when (currentValue) {
            1 -> binding.diceImage.setImageResource(R.drawable.dice1)
            2 -> binding.diceImage.setImageResource(R.drawable.dice2)
            3 -> binding.diceImage.setImageResource(R.drawable.dice3)
            4 -> binding.diceImage.setImageResource(R.drawable.dice4)
            5 -> binding.diceImage.setImageResource(R.drawable.dice5)
            6 -> binding.diceImage.setImageResource(R.drawable.dice6)
        }

        binding.lastThrow.text = getString(R.string.previous_value, previousValue)
        binding.currentThrow.text = getString(R.string.current_value, currentValue)
    }

    private fun guessLower() {
        throwDice()

        if (currentValue < previousValue){
            Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show()
        }
        else {
            Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_LONG).show()
        }
    }

    private fun guessHigher() {
        throwDice()

        if (currentValue > previousValue){
            Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show()
        }
        else {
            Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_LONG).show()
        }
    }

    private fun guessEqual() {
        throwDice()

        if (currentValue == previousValue){
            Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show()
        }
        else {
            Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_LONG).show()
        }
    }
}