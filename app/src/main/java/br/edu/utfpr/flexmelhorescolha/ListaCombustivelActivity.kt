package br.edu.utfpr.flexmelhorescolha

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ListaCombustivelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_combustivel)

        val listView: ListView = findViewById(R.id.list_item)
        val tipos = resources.getStringArray(R.array.Tipos)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tipos)
        listView.adapter = adapter
    }
}
