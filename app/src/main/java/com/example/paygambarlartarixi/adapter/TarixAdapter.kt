package com.example.paygambarlartarixi.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.paygambarlartarixi.databinding.ImageLayoutBinding

class TarixAdapter : RecyclerView.Adapter<TarixAdapter.TarixViewHolder>() {

    lateinit var onItemClicked: (com.example.paygambarlartarixi.database.Image) -> Unit
    var imageList: MutableList<com.example.paygambarlartarixi.database.Image> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarixViewHolder {
        return TarixViewHolder(
            ImageLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: TarixViewHolder, position: Int) {
        holder.find(imageList[position])
    }

    override fun getItemCount(): Int = imageList.size

    inner class TarixViewHolder(private val binding: ImageLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun find(image: com.example.paygambarlartarixi.database.Image) {
            binding.imageView.setImageResource(image.image)
            itemView.setOnClickListener {
                onItemClicked.invoke(image)
            }
        }

    }

}