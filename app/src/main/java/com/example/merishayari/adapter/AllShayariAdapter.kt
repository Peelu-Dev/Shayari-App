package com.example.merishayari.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.merishayari.AllShayariActivity
import com.example.merishayari.databinding.ItemShayariBinding
import com.example.merishayari.model.ShayariModel

// making adapter to render all shayari from firebase

class AllShayariAdapter(
    val allShayariActivity: AllShayariActivity,
    val shayariList: ArrayList<ShayariModel>
) :RecyclerView.Adapter<AllShayariAdapter.ShayariViewHolder>(){
    // implementing all members
    // added shayariViewHolder class
    class ShayariViewHolder(val binding: ItemShayariBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShayariViewHolder {
        // binding ShayariViewHolder with ItemShayariBinding
        return  ShayariViewHolder(ItemShayariBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ShayariViewHolder, position: Int) {
        holder.binding.itemShayari.text = shayariList[position].data.toString()
    }

    override fun getItemCount() = shayariList.size
}