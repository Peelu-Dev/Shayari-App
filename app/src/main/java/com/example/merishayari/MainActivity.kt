package com.example.merishayari

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.merishayari.adapter.CategoryAdaptor
import com.example.merishayari.databinding.ActivityMainBinding
import com.example.merishayari.model.CategoryModel
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var db:FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            db = FirebaseFirestore.getInstance()

        db.collection("Shayari").addSnapshotListener{ value,error ->
            val shayari = arrayListOf<CategoryModel>()
            val data = value?.toObjects(CategoryModel::class.java)
            shayari.addAll(data!!)
            binding.recyclerViewCategory.layoutManager = LinearLayoutManager(this)
            binding.recyclerViewCategory.adapter = CategoryAdaptor(this,shayari)
        }
//        val shayari = arrayListOf("Love Shayari","Attitude Shayari","Romantic Shayari")



        binding.btnMenu.setOnClickListener{
            if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            }else{
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        binding.navigationLayout.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.Share -> {
                    try {
                        val shareIntent = Intent(Intent.ACTION_SEND)
                        shareIntent.type = "text/plain"
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name")
                        var shareMessage = "Install this App to get new hindi Shayariaan"
                        shareMessage =
                            """
                            ${shareMessage}https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}
                            
                            
                            """.trimIndent()
                        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                        startActivity(Intent.createChooser(shareIntent, "choose one"))
                    } catch (e: Exception) {
                        //e.toString();
                    }
                    true
                }
                R.id.rate -> {
                    try {
                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
                    } catch (e: ActivityNotFoundException) {
                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")))
                    }
                    true
                }
                R.id.more -> {
                    val uri = Uri.parse("market://details?id=com.wordel")
                    val myAppLinkToMarket = Intent(Intent.ACTION_VIEW, uri)
                    try {
                        startActivity(myAppLinkToMarket)
                    } catch (e: ActivityNotFoundException) {
                        Toast.makeText(this, " unable to find market app", Toast.LENGTH_LONG).show()
                    }
                    true
                }else -> {
                    false
                }
            }
        }

    }
    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }
}