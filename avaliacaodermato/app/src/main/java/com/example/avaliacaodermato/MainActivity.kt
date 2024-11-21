package com.example.avaliacaodermato

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton: Button = findViewById(R.id.btnStart)
        val nameEditText: EditText = findViewById(R.id.edtName)

        startButton.setOnClickListener {
            val name = nameEditText.text.toString()

            if (name.isBlank()) {
                Toast.makeText(this, "Por favor, digite seu nome", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra("PATIENT_NAME", name)
                startActivity(intent)
            }
        }
    }
}
