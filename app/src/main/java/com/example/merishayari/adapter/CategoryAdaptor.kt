package com.example.merishayari.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.merishayari.MainActivity
import com.example.merishayari.databinding.ItemCategoryBinding

class CategoryAdaptor(val mainActivity: MainActivity, val shayari: ArrayList<String>) : RecyclerView.Adapter<CategoryAdaptor.CatViewHolder>(){
    class CatViewHolder( val binding:ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder(
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.binding.itemText.text = shayari[position].toString()
    }

    override fun getItemCount() = shayari.size
}