package com.example.contextualcards.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contextualcards.databinding.ContextualCardBinding
import com.example.contextualcards.models.Card
import java.util.*

class NestedHomeAdapter(private val list: ArrayList<Card>) : RecyclerView.Adapter<NestedHomeAdapter.ViewHolder?>() {

    inner class ViewHolder(var binding: ContextualCardBinding): RecyclerView.ViewHolder(binding.root) {
        var itemView1: ContextualCardBinding = binding

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ContextualCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }

}