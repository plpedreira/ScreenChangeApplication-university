package com.example.screenchangeapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class AverageCalcActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_average_calculator)

        val nota1 = findViewById<TextInputEditText>(R.id.grade1)
        val nota2 = findViewById<TextInputEditText>(R.id.grade2)
        val nota3 = findViewById<TextInputEditText>(R.id.grade3)

        fun captureGradesAndCalcAverage(): Double? {
            val nota1Value = nota1.text.toString()
            val nota2Value = nota2.text.toString()
            val nota3Value = nota3.text.toString()

            val nota1Double = nota1Value.toDoubleOrNull()
            val nota2Double = nota2Value.toDoubleOrNull()
            val nota3Double = nota3Value.toDoubleOrNull()

            if (nota1Double != null && nota2Double != null && nota3Double != null) {
                return (nota1Double + nota2Double + nota3Double) / 3.0
            }

            return null
        }

        val buttonAverage = findViewById<Button>(R.id.buttonAverage)

        buttonAverage.setOnClickListener {
            val averageView = findViewById<TextView>(R.id.averageView)
            val situationView = findViewById<TextView>(R.id.situationView)

            val result = captureGradesAndCalcAverage()

            if (result != null) {
                averageView.text = "Media: ${String.format("%.2f", result)}"
                if (result >= 6.0) {
                    situationView.text = "Situation: Aprovado Parabens!"
                }
                if (result < 6.0) {
                    situationView.text = "Situation: Reprovado ;-; !"
                }
            }

            if (result == null) {
                averageView.text = "Please enter valid grades"
            }
        }

        val buttonHome = findViewById<Button>(R.id.ButtonHome)

        buttonHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}