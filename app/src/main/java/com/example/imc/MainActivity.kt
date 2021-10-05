package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var peso = findViewById<EditText>(R.id.input_peso)
        var altura = findViewById<EditText>(R.id.input_altura)

        var calcular = findViewById<Button>(R.id.btncalcular)
        var limpar = findViewById<Button>(R.id.btLimpar)

        var resultado = findViewById<TextView>(R.id.result)



        calcular.setOnClickListener {
            calcTax(peso.text.toString().toDouble(),
                    altura.text.toString().toDouble())
        }

        limpar.setOnClickListener {
            peso.setText("")
            altura.setText("")
            resultado.setText("")
            peso.requestFocus()

        }
    }
    fun calcTax(peso: Double, altura: Double) {

        var ResultadoIMC = peso / (altura * altura)
        if (ResultadoIMC < 17) {
            var resultado = findViewById<TextView>(R.id.result)
            resultado.text = resources.getString(R.string.muito_abaixo, ResultadoIMC)
        } else if (ResultadoIMC < 18.5) {
            var resultado = findViewById<TextView>(R.id.result)
            resultado.text = resources.getString(R.string.abaixo,ResultadoIMC)
        } else if (ResultadoIMC < 24.9) {
            var resultado = findViewById<TextView>(R.id.result)
            resultado.text = resources.getString(R.string.normal,ResultadoIMC)
        } else if (ResultadoIMC < 29.9) {
            var resultado = findViewById<TextView>(R.id.result)
            resultado.text = resources.getString(R.string.acima,ResultadoIMC)
        } else if (ResultadoIMC < 34.9) {
            var resultado = findViewById<TextView>(R.id.result)
            resultado.text = resources.getString(R.string.obesidadeI,ResultadoIMC)
        } else if (ResultadoIMC < 39.9) {
            var resultado = findViewById<TextView>(R.id.result)
            resultado.text = resources.getString(R.string.obesidadeII,ResultadoIMC)
        } else {
            var resultado = findViewById<TextView>(R.id.result)
            resultado.text = resources.getString(R.string.obesidadeIII,ResultadoIMC)
        }

/*NÃO SEI O QUE DEU ERRADO
 var f = NumberFormat.getCurrencyInstance()
resultado.text = resources.getString(R.string.obesidadeIII, f.format(ResultadoIMC))*/

    }

}

