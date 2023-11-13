package com.ruben.project_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ruben.project_list.databinding.ActivityLlistaBinding

class LlistaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLlistaBinding
    private lateinit var dataList: ArrayList<String>
    private lateinit var adapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_llista)

        dataList = intent.getStringArrayListExtra("dataList") ?: ArrayList()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = DataAdapter(dataList)
        binding.recyclerView.adapter = adapter

        binding.buttonVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
            finish()
        }
    }
}


