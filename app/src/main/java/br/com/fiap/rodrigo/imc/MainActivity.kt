package br.com.fiap.rodrigo.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener {
            val nextScreen = Intent(this, ResultActivity::class.java)

            nextScreen.putExtra("WEIGHT", inputWeight.text.toString())
            nextScreen.putExtra("HEIGHT", inputHeight.text.toString())
            nextScreen.putExtra("SEX", spSex.selectedItem.toString())

            startActivity(nextScreen)
        }

        btnClear.setOnClickListener {
            inputWeight.setText("")
            inputHeight.setText("")
            spSex.setSelection(0)
        }
    }
}
