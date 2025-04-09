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

        val peso = findViewById<TextInputEditText>(R.id.weight)
        val altura = findViewById<TextInputEditText>(R.id.height)

        fun captureAndCalcIMC(): String? {
            val pesoValue = peso.text.toString()
            val alturaValue = altura.text.toString()

            val pesoDouble = pesoValue.toDoubleOrNull()
            val alturaDouble = alturaValue.toDoubleOrNull()

            if (pesoDouble != null && alturaDouble != null) {
                val imc = pesoDouble / Math.pow(alturaDouble, 2.0)
                return when {
                    imc < 18.5 -> "Abaixo do peso"
                    imc in 18.5..24.9 -> "Peso normal"
                    imc in 25.0..29.9 -> "Acima do peso"
                    imc in 30.0..34.9 -> "Obesidade nivel 1"
                    imc in 35.0..39.9 -> "Obesidade nivel 2"
                    else -> "Obesidade nivel 3"
                }
            }
            return null
        }

        val imcCalcButton = findViewById<Button>(R.id.calculateIMC)

        imcCalcButton.setOnClickListener {
            val imcTextView = findViewById<TextView>(R.id.ViewIMC)

            val result = captureAndCalcIMC()

            if (result != null) {
                imcTextView.text = "De acordo com o IMC voce se classifica como: $result"
            } else {
                imcTextView.text = "coloque um peso e altura valido"
            }
        }

        val buttonHome = findViewById<Button>(R.id.ButtonHome)

        buttonHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}