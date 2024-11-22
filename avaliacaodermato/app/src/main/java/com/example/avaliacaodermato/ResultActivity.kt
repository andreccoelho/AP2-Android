package com.example.avaliacaodermato

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.net.Uri
import android.widget.Button


class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Receber os dados do Intent
        val patientName = intent.getStringExtra("PATIENT_NAME") ?: "Paciente"
        val oiliness = intent.getIntExtra("OILINESS", 0)
        val usesSunscreen = intent.getBooleanExtra("SUNSCREEN", false)
        val routine = intent.getStringExtra("ROUTINE")
        val cleaningFrequency = intent.getStringExtra("CLEANING_FREQUENCY")
        val skinType = intent.getStringExtra("SKIN_TYPE")
        val sunExposure = intent.getStringExtra("SUN_EXPOSURE")

        // Referência ao TextView
        val resultTextView: TextView = findViewById(R.id.txtResult)

        // Lógica de análise com base nas respostas
        val sunscreenMessage = if (usesSunscreen) {
            "Parabéns por usar protetor solar diariamente! Continue assim."
        } else {
            "Recomendamos usar protetor solar diariamente para proteger sua pele."
        }

        val oilinessMessage = if (oiliness > 7) {
            "Sua pele é muito oleosa. Recomendamos produtos oil-free e controle diário da oleosidade com produtos específicos."
        } else if (oiliness in 4..7) {
            "Sua pele tem oleosidade moderada. Continue cuidando com produtos adequados."
        } else {
            "Sua pele tem baixa oleosidade. Mantenha uma hidratação regular."
        }

        val skinTypeMessage = when (skinType) {
            "Oleosa" -> "Sua pele oleosa requer produtos leves e que controlem o excesso de óleo."
            "Seca" -> "Sua pele seca precisa de hidratação intensa. Use cremes nutritivos."
            "Mista" -> "Sua pele mista precisa de cuidados equilibrados para zonas oleosas e secas."
            "Normal" -> "Sua pele normal está equilibrada. Continue com sua rotina atual."
            else -> "Tipo de pele não identificado."
        }

        val cleaningMessage = when (cleaningFrequency) {
            "1 vez por dia" -> "Recomendamos limpar o rosto pelo menos 2 vezes ao dia para remover impurezas."
            "2 vezes por dia" -> "Ótimo! Limpar o rosto 2 vezes ao dia é o ideal."
            "3 vezes ou mais" -> "Limpar o rosto mais de 3 vezes pode ressecar a pele. Reduza para 2 vezes ao dia."
            else -> "Frequência de limpeza não identificada."
        }

        val sunExposureMessage = when (sunExposure) {
            "Diária" -> "Se você se expõe ao sol diariamente, é crucial usar protetor solar com FPS alto."
            "Frequente" -> "Uma exposição frequente ao sol requer cuidados com hidratação e proteção solar."
            "Rara" -> "Mesmo com exposição rara, use protetor solar para evitar danos ocasionais."
            "Nunca" -> "Mesmo sem exposição direta ao sol, proteja-se contra luzes artificiais e hidratantes adequados."
            else -> "Frequência de exposição ao sol não identificada."
        }

        // Combinar os resultados em uma mensagem final
        val resultMessage = """
            $patientName, o seu resultado é:
            
            - Nível de oleosidade: $oiliness/10
            $oilinessMessage

            - Tipo de pele: $skinType
            $skinTypeMessage

            - Rotina de cuidados: $routine
            $cleaningMessage

            - Protetor solar: ${if (usesSunscreen) "Sim" else "Não"}
            $sunscreenMessage

            - Frequência de exposição ao sol: $sunExposure
            $sunExposureMessage
        """.trimIndent()

        // Exibir o resultado no TextView
        resultTextView.text = resultMessage

        // Configuração do botão para redirecionar ao Instagram
        val btnSubmit: Button = findViewById(R.id.btnSubmit)
        btnSubmit.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.instagram.com/andreacostadermato/")
            )
            startActivity(intent)
        }
    }
}
