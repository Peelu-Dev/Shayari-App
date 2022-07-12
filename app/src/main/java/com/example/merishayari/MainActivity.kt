package com.example.merishayari

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.merishayari.databinding.ActivityStartBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}