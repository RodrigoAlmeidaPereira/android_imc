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
        calculate()
    }

    private fun calculate() {
        val imc = weight / (height * height)
        tvImc.text = imc.toFixed(2)

        when {
            imc < 18.5 -> {
                tvStatusImc.text = "Abaixo do peso"
                if (sex.equals(R.string.label_sex_female)) {
                    setImage(R.drawable.fem_abaixo)
                } else {
                    setImage(R.drawable.masc_abaixo)
                }
            }
            imc < 24.9 -> {
                tvStatusImc.text = "Peso ideal"
                if (sex.equals(R.string.label_sex_female)) {
                    setImage(R.drawable.fem_ideal)
                } else {
                    setImage(R.drawable.masc_ideal)
                }
            }
            imc < 29.9 -> {
                tvStatusImc.text = "Levemente acima do peso"
                if (sex.equals(R.string.label_sex_female)) {
                    setImage(R.drawable.fem_sobre)
                } else {
                    setImage(R.drawable.masc_sobre)
                }
            }
            imc < 34.9 -> {
                tvStatusImc.text = "Obeso"
                if (sex.equals(R.string.label_sex_female)) {
                    setImage(R.drawable.fem_obeso)
                } else {
                    setImage(R.drawable.masc_obeso)
                }
            }
            else -> {
                tvStatusImc.text = "Extremamente Obeso"
                if (sex.equals(R.string.label_sex_female)) {
                    setImage(R.drawable.fem_extremo_obeso)
                } else {
                    setImage(R.drawable.masc_extremo_obeso)
                }
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
