package br.edu.utfpr.flexmelhorescolha

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalcular: Button = findViewById(R.id.buttonCalcular)
        val buttonLimpar: Button = findViewById(R.id.buttonLimpar)
        val buttonBuscar1: Button = findViewById(R.id.btnBuscarComb1)
        val buttonBuscar2: Button = findViewById(R.id.btnBuscarComb2)

        buttonCalcular.setOnClickListener {
            val consumoGasolina = findViewById<EditText>(R.id.consumoGasolina).text.toString().toDoubleOrNull()
            val consumoAlcool = findViewById<EditText>(R.id.consumoAlcool).text.toString().toDoubleOrNull()
            val valorGasolina = findViewById<EditText>(R.id.valorGasolina).text.toString().toDoubleOrNull()
            val valorAlcool = findViewById<EditText>(R.id.valorAlcool).text.toString().toDoubleOrNull()
            val textViewResultado: TextView = findViewById(R.id.textViewResultado)

            if (consumoGasolina != null && consumoAlcool != null && valorGasolina != null && valorAlcool != null) {
                val razao = valorAlcool / valorGasolina
                if (razao < 0.7) {
                    textViewResultado.text = getString(R.string.alcool_mais_vantajoso)
                } else {
                    textViewResultado.text = getString(R.string.gasolina_mais_vantajosa)
                }
            } else {
                textViewResultado.text = getString(R.string.mensagem_erro_zerado)
            }
        }

        // Implementando o botão Limpar
        buttonLimpar.setOnClickListener {
            findViewById<EditText>(R.id.consumoGasolina).setText("")
            findViewById<EditText>(R.id.consumoAlcool).setText("")
            findViewById<EditText>(R.id.valorGasolina).setText("")
            findViewById<EditText>(R.id.valorAlcool).setText("")
            findViewById<TextView>(R.id.textViewResultado).text = ("")
        }

        // Implementando o botão Buscar combustível
        buttonBuscar1.setOnClickListener {
            val intent = Intent(this, ListaCombustivelActivity::class.java)
            startActivity(intent)
        }

        buttonBuscar2.setOnClickListener {
            val intent = Intent(this, ListaCombustivelActivity::class.java)
            startActivity(intent)
        }
    }
}
