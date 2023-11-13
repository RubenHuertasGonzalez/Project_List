package com.ruben.project_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.ruben.project_list.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val dataList = ArrayList<String>() // ArrayList para almacenar datos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        binding.buttonAfegir.setOnClickListener {
            val nombre = binding.editTextNom.text.toString()
            val edad = binding.editTextEdat.text.toString()

            if (nombre.isNotEmpty() && edad.isNotEmpty()) {
                dataList.add("Nombre: $nombre, Edad: $edad")

                binding.editTextNom.text.clear()
                binding.editTextEdat.text.clear()

                Toast.makeText(this, "Datos añadidos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Por favor, completa ambos campos", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonSeguent.setOnClickListener {
            val intent = Intent(this, LlistaActivity::class.java)
            intent.putStringArrayListExtra("dataList", dataList)
            startActivity(intent)
        }
    }
}


