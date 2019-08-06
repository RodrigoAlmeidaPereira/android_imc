package br.com.fiap.rodrigo.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    var weight = 0.0
    var height = 0.0
    lateinit var sex : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        loadData()
        caluclate()
    }

    private fun caluclate() {
        val imc = weight / (height * height)
        tvImc.text = imc.toString()

        when {
            imc < 18.5 -> {
                tvStatusImc.text = "Abaixo do peso"
                setImage(R.drawable.fem_abaixo)
            }
            imc < 24.9 -> {
                tvStatusImc.text = "Peso ideal"
                setImage(R.drawable.fem_ideal)
            }
            imc < 29.9 -> {
                tvStatusImc.text = "Levemente acima do peso"
                setImage(R.drawable.fem_sobre)
            }
            imc < 34.9 -> {
                tvStatusImc.text = "Obeso"
                setImage(R.drawable.fem_obeso)
            }
            else -> {
                tvStatusImc.text = "Extremamente Obeso"
                setImage(R.drawable.fem_extremo_obeso)
            }
        }
    }

    private fun setImage(resourceId: Int) {
        ivImc.setImageDrawable(ContextCompat.getDrawable(this, resourceId))
    }

    private fun loadData() {
        weight = intent.getStringExtra("WEIGHT").toDouble()
        height = intent.getStringExtra("HEIGHT").toDouble()
        sex = intent.getStringExtra("SEX")
    }
}
