package com.royrine.imc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.royrine.imc.extension.format
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val peso = intent?.getStringExtra("PESO")!!.toDouble()
        val altura = intent?.getStringExtra("ALTURA")!!.toDouble()

        val imc = peso / (altura * altura)

        tvIMC.setText(imc?.format(1))

        if(imc < 18.4) {
            alterarImagemStatusIMC(R.drawable.magreza)
            alterarTextoStatusIMC("Magro demais")
        }else if(imc <= 18.5){
                alterarImagemStatusIMC(R.drawable.abaixo)
                alterarTextoStatusIMC("Abaixo do Peso")
        }else if(imc <= 24.9){
            alterarImagemStatusIMC(R.drawable.ideal)
            alterarTextoStatusIMC("Peso Ideal")
        }else if(imc <= 29.8){
            alterarImagemStatusIMC(R.drawable.sobre)
            alterarTextoStatusIMC("Levemente acima do Peso")
        }else if(imc <= 34.8){
            alterarImagemStatusIMC(R.drawable.obesidade)
            alterarTextoStatusIMC("Obesidade Grau I")
        }else if(imc <= 39.9){
            alterarImagemStatusIMC(R.drawable.obesidade)
            alterarTextoStatusIMC("Obesidade Grau II (Severa)")
        }else if(imc > 40.0){
            alterarImagemStatusIMC(R.drawable.obesidade)
            alterarTextoStatusIMC("Obrisidade Grau III (Mórbida)")
        }
    }

    fun alterarImagemStatusIMC(idImagem: Int){
        ivStatusIMC.setImageDrawable(ContextCompat.getDrawable(this, idImagem))
    }

    fun alterarTextoStatusIMC(text: String){
        tvStatusIMC.text = text
    }
}
