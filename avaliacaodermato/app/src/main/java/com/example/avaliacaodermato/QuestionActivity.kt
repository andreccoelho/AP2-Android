package com.example.avaliacaodermato

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.avaliacaodermato.R

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)


        val submitButton: Button = findViewById(R.id.btnSubmit)
        val switchSunscreen: Switch = findViewById(R.id.switchSunscreen)
        val seekBarOiliness: SeekBar = findViewById(R.id.seekBarOiliness)
        val spinnerRoutine: Spinner = findViewById(R.id.spinnerRoutine)
        val spinnerCleaningFrequency: Spinner = findViewById(R.id.spinnerCleaningFrequency)
        val spinnerSkinType: Spinner = findViewById(R.id.spinnerSkinType)
        val spinnerSunExposure: Spinner = findViewById(R.id.spinnerSunExposure)

        // Dados para os spinners
        val routineOptions = arrayOf("Básica", "Intermediária", "Avançada")
        val cleaningFrequencyOptions = arrayOf("1 vez por dia", "2 vezes por dia", "3 vezes ou mais")
        val skinTypeOptions = arrayOf("Oleosa", "Seca", "Mista", "Normal")
        val sunExposureOptions = arrayOf("Diária", "Frequente", "Rara", "Nunca")

        // Configurar adaptadores para os spinners
        spinnerRoutine.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, routineOptions)
        spinnerCleaningFrequency.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cleaningFrequencyOptions)
        spinnerSkinType.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, skinTypeOptions)
        spinnerSunExposure.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sunExposureOptions)

        submitButton.setOnClickListener {
            val oiliness = seekBarOiliness.progress
            val usesSunscreen = switchSunscreen.isChecked
            val routine = spinnerRoutine.selectedItem.toString()
            val cleaningFrequency = spinnerCleaningFrequency.selectedItem.toString()
            val skinType = spinnerSkinType.selectedItem.toString()
            val sunExposure = spinnerSunExposure.selectedItem.toString()

            val patientName = intent.getStringExtra("PATIENT_NAME") ?: "Paciente"
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("PATIENT_NAME", patientName) // Adicione o nome ao Intent
            intent.putExtra("OILINESS", oiliness)
            intent.putExtra("SUNSCREEN", usesSunscreen)
            intent.putExtra("ROUTINE", routine)
            intent.putExtra("CLEANING_FREQUENCY", cleaningFrequency)
            intent.putExtra("SKIN_TYPE", skinType)
            intent.putExtra("SUN_EXPOSURE", sunExposure)
            startActivity(intent)

            startActivity(intent)
        }
    }
}
