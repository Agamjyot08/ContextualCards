package com.example.contextualcards.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contextualcards.databinding.ContextualCardBinding
import com.example.contextualcards.models.Card
import com.example.contextualcards.models.CardGroup
import java.util.*

class NestedHomeAdapter(private val list: ArrayList<CardGroup>) : RecyclerView.Adapter<NestedHomeAdapter.ViewHolder?>() {

    private var adapter : RecyclerAdapter? = null

    inner class ViewHolder(var binding: ContextualCardBinding): RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ContextualCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position].cards
        adapter = RecyclerAdapter(ArrayList(item), list[position].design_type)

        holder.binding.recycler.layoutManager = LinearLayoutManager(holder.binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        holder.binding.recycler.adapter = adapter

    }

    override fun getItemCount(): Int {
        return list.size
    }

}