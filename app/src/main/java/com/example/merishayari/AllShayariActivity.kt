package com.example.merishayari

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.merishayari.adapter.AllShayariAdapter
import com.example.merishayari.databinding.ActivityAllShayariBinding
import com.example.merishayari.model.ShayariModel
import com.google.firebase.firestore.FirebaseFirestore

class AllShayariActivity : AppCompatActivity() {
    lateinit var binding : ActivityAllShayariBinding
    lateinit var db : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllShayariBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // instance of firebase database
        db = FirebaseFirestore.getInstance()

        val name = intent.getStringExtra("name")
        val id = intent.getStringExtra("id")

        binding.btnBack.setOnClickListener{
            onBackPressed()
        }

        binding.catName.text = name.toString()

        db.collection("Shayari").document(id!!).collection("all")
            .addSnapshotListener{ value,error ->
                val shayariList = arrayListOf<ShayariModel>()
                val data = value?.toObjects(ShayariModel::class.java)
                shayariList.addAll(data!!)
                binding.rcvAllShayari.layoutManager = LinearLayoutManager(this)
                binding.rcvAllShayari.adapter = AllShayariAdapter(this,shayariList)

            }

    }
}