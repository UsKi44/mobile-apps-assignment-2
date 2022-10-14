package com.example.assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstNumber = findViewById<EditText>(R.id.firstNumber)
        val secondNumber = findViewById<EditText>(R.id.secondNumber)

        val sumBtn = findViewById<Button>(R.id.sumBtn)
        val deductionBtn = findViewById<Button>(R.id.deductionBtn)
        val multiplyBtn = findViewById<Button>(R.id.multiplyBtn)
        val divideBtn = findViewById<Button>(R.id.divideBtn)

        fun clearInputs() {
            firstNumber.setText("")
            secondNumber.setText("")
        }


        sumBtn.setOnClickListener {
            val firstInput = firstNumber.text.toString()
            val secondInput = secondNumber.text.toString()

            if (firstInput != "" && secondInput != "") {
                val result = firstInput.toInt() + secondInput.toInt()
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("Answer", result.toString())
                startActivity(intent)

                clearInputs()
            }
        }

        deductionBtn.setOnClickListener {
            val firstInput = firstNumber.text.toString()
            val secondInput = secondNumber.text.toString()

            if(firstInput != "" && secondInput!= "") {
                val result = firstInput.toInt() - secondInput.toInt()
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("Answer", result.toString())
                startActivity(intent)

                clearInputs()
            }
        }

        multiplyBtn.setOnClickListener {
            val firstInput = firstNumber.text.toString()
            val secondInput = secondNumber.text.toString()

            if(firstInput != "" && secondInput != "") {
                val result = firstInput.toInt() * secondInput.toInt()
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("Answer", result.toString())
                startActivity(intent)

                clearInputs()
            }
        }

        divideBtn.setOnClickListener {
            val firstInput = firstNumber.text.toString()
            val secondInput = secondNumber.text.toString()

            if(firstInput != "" && secondInput != "") {
                if(secondInput.toInt() != 0) {
                    val result: Double = firstInput.toDouble() / secondInput.toDouble()
                    val rounded: Double = String.format("%.2f", result).toDouble()
                    val intent = Intent(this, SecondActivity::class.java)
                    intent.putExtra("Answer", rounded.toString())
                    startActivity(intent)

                    clearInputs()
                } else {
                    val result = "There was an error"
                    val intent = Intent(this, SecondActivity::class.java)
                    intent.putExtra("Answer", result)
                    startActivity(intent)

                    clearInputs()
                }
            }

        }



    }


}