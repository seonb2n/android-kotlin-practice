package com.example.kotlinapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText: EditText = findViewById(R.id.editText_height)
        val weightEditText = findViewById<EditText>(R.id.editText_weight)

        val resultButton = findViewById<Button>(R.id.button_Result)
        val resultTextView = findViewById<TextView>(R.id.textView_Result)

        resultButton.setOnClickListener{
            Log.d("MainActivity", "ResultButton is clicked")

            if(heightEditText.text.isEmpty() || weightEditText.text.isEmpty()) {
                Toast.makeText(this, "Empty value", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val height: Int = heightEditText.text.toString().toInt()
            val weight: Int = weightEditText.text.toString().toInt()

            Log.d("MainActivity", "height : $height weight : $weight")

            val bmi = weight / (height / 100.0).pow(2.0)
            val resulText = when {
                bmi >= 35.0 -> "고도 비만"
                bmi >= 30.0 -> "중정도 비만"
                bmi >= 25.0 -> "경도 비만"
                bmi >= 23.0 -> "과체중"
                bmi >= 18.5 -> "정상체중"
                else -> "저체중"
            }
            resultTextView.setText(resulText)

        }

    }

}