package com.example.screenchangeapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import kotlin.reflect.typeOf

class ImcCalcActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)

        val weight = findViewById<TextInputEditText>(R.id.weight)
        val height = findViewById<TextInputEditText>(R.id.height)

        fun captureAndCalcIMC(): String? {
            val weightValue = weight.text.toString()
            val heightValue = height.text.toString()

            val weightDouble = weightValue.toDoubleOrNull()
            val heightDouble = heightValue.toDoubleOrNull()

            if (weightDouble != null && heightDouble != null) {
                val IMC = weightDouble / Math.pow(heightDouble, 2.0)
                return when {
                    IMC < 18.5 -> "Underweight"
                    IMC in 18.5..24.9 -> "Normal weight"
                    IMC in 25.0..29.9 -> "Overweight"
                    IMC in 30.0..34.9 -> "Obesity grade 1"
                    IMC in 35.0..39.9 -> "Obesity grade 2"
                    else -> "Obesity grade 3"
                }
            }
            return null
        }

        val IMCCalcButton = findViewById<Button>(R.id.calculateIMC)

        IMCCalcButton.setOnClickListener {
            val IMCTextView = findViewById<TextView>(R.id.ViewIMC)

            val result = captureAndCalcIMC()

            if (result != null) {
                IMCTextView.text = "Your IMC result is: $result"
            } else {
                IMCTextView.text = "Please enter valid weight and height"
            }
        }

        val buttonHome = findViewById<Button>(R.id.ButtonHome)

        buttonHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}