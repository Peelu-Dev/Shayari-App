package com.example.merishayari

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.merishayari.databinding.ActivityStartBinding


class StartActivity : AppCompatActivity() {
    // made binding variable to bind the app with different screens
    private lateinit var binding:ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // added setOnclick listener on btn start to navigate to mainActivity file
        binding.btnStart.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

        // added setOnclick listener on btn rate to navigate to rate the app on play Store
        binding.btnRate.setOnClickListener{
            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
            } catch (e: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")))
            }
        }


        // added setOnclick listener on btn start to navigate to wordel app
        binding.btnMore.setOnClickListener{
            val uri = Uri.parse("market://details?id=com.wordel")
            val myAppLinkToMarket = Intent(Intent.ACTION_VIEW, uri)
            try {
                startActivity(myAppLinkToMarket)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, " unable to find market app", Toast.LENGTH_LONG).show()
            }
        }
    }
}