package com.example.contextualcards.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.contextualcards.databinding.*
import com.example.contextualcards.models.Card
import java.util.*


class RecyclerAdapter(private var cardGroup: ArrayList<Card>, private val design_type: String) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {

    var CARDHC1 = 1
    var CARDHC3 = 3
    var CARDHC5 = 5
    var CARDHC6 = 6
    var CARDHC9 = 9


    override fun getItemViewType(position: Int): Int {
        return if (design_type == "HC1") {
            CARDHC1
        } else if (design_type == "HC3") {
            CARDHC3
        } else if (design_type == "HC5") {
            CARDHC5
        } else if (design_type == "HC6") {
            CARDHC6
        } else {
            CARDHC9
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == CARDHC1) {
            ViewHolderHc1(Hc1CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        } else if (viewType == CARDHC3) {
            ViewHolderHc3(Hc3CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        } else if (viewType == CARDHC5) {
            ViewHolderHc5(Hc5CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        } else if(viewType == CARDHC6) {
            ViewHolderHc6(Hc6CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }else {
            ViewHolderHc9(Hc9CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val card: Card = cardGroup[position]
        Log.d("LogTag3", card.name.toString())

        if (getItemViewType(position) == CARDHC1) {
            (holder as ViewHolderHc1).setHc1Card(card)
        }
        else if (getItemViewType(position) == CARDHC3) {
            (holder as ViewHolderHc3).setHc3Card(card)
        }
        else if (getItemViewType(position) == CARDHC5) {
            (holder as ViewHolderHc5).setHc5Card(card)
        }
        else if (getItemViewType(position) == CARDHC6) {
            (holder as ViewHolderHc6).setHc6Card(card)
        }
        else {
            (holder as ViewHolderHc9).setHc9Card(card)
        }
    }

    override fun getItemCount(): Int {
        return cardGroup.size
    }

    internal class ViewHolderHc1(itemView: Hc1CardItemBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        var itemView1: Hc1CardItemBinding
        @SuppressLint("SetTextI18n")
        fun setHc1Card(cardgrp: Card) {
                itemView1.root.setCardBackgroundColor(cardgrp.bg_color?.toColorInt() ?: return)
                itemView1.textview.text = cardgrp.name
                itemView1.imageView.load(cardgrp.icon.image_url)
                itemView1.root.isEnabled = !cardgrp.is_disabled

                itemView1.root.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(cardgrp.url))
                    startActivity(it.context, intent, null)
                }
//            }
        }

        init {
            this.itemView1 = itemView
        }
    }

    internal class ViewHolderHc3(itemview3: Hc3CardItemBinding) :
        RecyclerView.ViewHolder(itemview3.root) {
        var itemView3: Hc3CardItemBinding

        fun setHc3Card(reward: Card) {
            itemView3.imageView4.load(reward.bg_image.image_url)
            itemView3.textView.text = reward.title
            itemView3.textView2.text = reward.description
            itemView3.constraintLayout.backgroundTintList = ColorStateList.valueOf(reward.bg_color?.toColorInt() ?: return);

            itemView3.button.text = reward.cta[0].text
            itemView3.button.setBackgroundColor(reward.cta[0].bg_color.toColorInt())
            itemView3.button.setTextColor(reward.cta[0].text_color.toColorInt())
            itemView3.button.setOnClickListener{
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(reward.url))
                startActivity(it.context, intent, null)
            }
        }

        init {
            itemView3 = itemview3
        }
    }

    internal class ViewHolderHc5(itemview5: Hc5CardItemBinding) :
        RecyclerView.ViewHolder(itemview5.root) {
        var itemView5: Hc5CardItemBinding
        fun setHc5Card(cardgrp: Card) {

            itemView5.root.setBackgroundColor(cardgrp.bg_color?.toColorInt() ?: return)
            itemView5.imageView.load(cardgrp.bg_image.image_url)

            itemView5.root.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(cardgrp.url))
                startActivity(it.context, intent, null)
            }
        }

        init {
            itemView5 = itemview5
        }
    }


    internal class ViewHolderHc6(itemview3: Hc6CardItemBinding) :
        RecyclerView.ViewHolder(itemview3.root) {
        var itemView3: Hc6CardItemBinding
        fun setHc6Card(cardgrp: Card) {
            itemView3.imageView.load(cardgrp.icon.image_url)
            itemView3.text.text = cardgrp.description

            itemView3.root.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(cardgrp.url))
                startActivity(it.context, intent, null)
            }
        }

        init {
            itemView3 = itemview3
        }
    }

    internal class ViewHolderHc9(itemview4: Hc9CardItemBinding) :
        RecyclerView.ViewHolder(itemview4.root) {
        var itemView4: Hc9CardItemBinding
        fun setHc9Card(cardgrp: Card) {
            val layoutParams = itemView4.imageView.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.dimensionRatio = cardgrp.bg_image.aspect_ratio.toString()
            itemView4.imageView.load(cardgrp.bg_image.image_url)
            itemView4.root.isEnabled = !cardgrp.is_disabled

            itemView4.root.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(cardgrp.url))
                startActivity(it.context, intent, null)
            }
        }

        init {
            itemView4 = itemview4
        }
    }
}