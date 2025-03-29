package com.example.screenchangeapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.roundToLong

class AverageCalcActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_average_calculator)

        val grade1 = findViewById<TextInputEditText>(R.id.grade1)
        val grade2 = findViewById<TextInputEditText>(R.id.grade2)
        val grade3 = findViewById<TextInputEditText>(R.id.grade3)

        fun CaptureGradesAndCalcAverage(): Double? {
            val grade1Value = grade1.text.toString()
            val grade2Value = grade2.text.toString()
            val grade3Value = grade3.text.toString()

            val grade1Double = grade1Value.toDoubleOrNull()
            val grade2Double = grade2Value.toDoubleOrNull()
            val grade3Double = grade3Value.toDoubleOrNull()

            if (grade1Double != null && grade2Double != null && grade3Double != null) {
                return (grade1Double + grade2Double + grade3Double) / 3.0
            }

            return null
        }

        val buttonAverage = findViewById<Button>(R.id.buttonAverage)

        buttonAverage.setOnClickListener {
            val averageView = findViewById<TextView>(R.id.averageView)
            val situationView = findViewById<TextView>(R.id.situationView)

            val result = CaptureGradesAndCalcAverage()

            if (result != null) {
                averageView.text = "Average: ${String.format("%.2f", result)}"
                if (result >= 6.0) {
                    situationView.text = "Situation: Approved!"
                }
                if (result < 6.0) {
                    situationView.text = "Situation: Repproved!"
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