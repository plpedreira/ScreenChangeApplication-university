package com.example.screenchangeapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonIMC = findViewById<Button>(R.id.buttonIMC)
        val buttonInfo = findViewById<Button>(R.id.buttonInfo)
        val buttonAverage = findViewById<Button>(R.id.buttonAverage)

        buttonIMC.setOnClickListener {
            val intent = Intent(this, ImcCalcActivity::class.java)
            startActivity(intent)
        }

        buttonInfo.setOnClickListener {
            val intent = Intent(this, DuoInfoActivity::class.java)
            startActivity(intent)
        }

        buttonAverage.setOnClickListener {
            val intent = Intent(this, AverageCalcActivity::class.java)
            startActivity(intent)
        }
    }
}