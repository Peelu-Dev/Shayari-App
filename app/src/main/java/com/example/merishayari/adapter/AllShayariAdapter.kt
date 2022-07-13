package com.example.merishayari.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.merishayari.AllShayariActivity
import com.example.merishayari.R
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


        if(position%5==0){
            holder.binding.mainBackGRound.setBackgroundResource(R.drawable.gradient_1)
        }else if(position%5==1){
            holder.binding.mainBackGRound.setBackgroundResource(R.drawable.gradient_2)
        }else if(position%5==2){
            holder.binding.mainBackGRound.setBackgroundResource(R.drawable.gradient_3)
        }else if(position%5==3){
            holder.binding.mainBackGRound.setBackgroundResource(R.drawable.gradient_4)
        }else if(position%5==4){
            holder.binding.mainBackGRound.setBackgroundResource(R.drawable.gradient_5)
        }

        holder.binding.itemShayari.text = shayariList[position].data.toString()
    }

    override fun getItemCount() = shayariList.size
}