package br.edu.utfpr.flexmelhorescolha

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

        buttonCalcular.setOnClickListener {
            val consumoGasolina = findViewById<EditText>(R.id.consumoGasolina).text.toString().toDoubleOrNull()
            val consumoAlcool = findViewById<EditText>(R.id.consumoAlcool).text.toString().toDoubleOrNull()
            val valorGasolina= findViewById<EditText>(R.id.valorGasolina).text.toString().toDoubleOrNull()
            val valorAlcool= findViewById<EditText>(R.id.valorAlcool).text.toString().toDoubleOrNull()
            val textViewResultado: TextView = findViewById(R.id.textViewResultado)

            if (consumoGasolina != null && consumoAlcool != null && valorGasolina != null && valorAlcool != null) {
                val razao = valorAlcool / valorGasolina
                if (razao < 0.7) {
                    getString(R.string.alcool_mais_vantajoso).also { textViewResultado.text = it }
                } else {
                    textViewResultado.text = getString(R.string.gasolina_mais_vantajosa)
                }
            } else {
                textViewResultado.text = getString(R.string.por_favor_insira_valores_v_lidos)
            }

        }

        //Implementando o botao Limpar
        buttonLimpar.setOnClickListener {
                this.findViewById<EditText>(R.id.consumoGasolina).setText("")
                this.findViewById<EditText>(R.id.consumoAlcool).setText("")
                this.findViewById<EditText>(R.id.valorGasolina).setText("")
                this.findViewById<EditText>(R.id.valorAlcool).setText("")
                this.findViewById<TextView>(R.id.textViewResultado).text = ""
        }



    }
}