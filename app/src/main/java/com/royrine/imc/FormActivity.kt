package com.royrine.imc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        btClean.setOnClickListener{
            inputAltura.editText?.setText("")
            inputPeso.editText?.setText("")
            inputPeso.editText?.requestFocus()
        }
    }
}
