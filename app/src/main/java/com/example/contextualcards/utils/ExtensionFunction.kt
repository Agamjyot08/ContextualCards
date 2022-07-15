package com.example.contextualcards.utils

import android.content.Context
import android.graphics.Color
import android.view.View
import androidx.core.content.ContextCompat
import com.example.contextualcards.R
import com.google.android.material.snackbar.BaseTransientBottomBar.ANIMATION_MODE_SLIDE
import com.google.android.material.snackbar.Snackbar

fun View.snackbar(context: Context, flag : Int, message: String, action: (() -> Unit)? = null) {
    val snackbar: Snackbar = when (flag) {
        0 -> {// Infinite
            Snackbar.make(this, message, Snackbar.LENGTH_INDEFINITE)
        }
        1 -> {//Length
            Snackbar.make(this, message, Snackbar.LENGTH_LONG)
        }
        else -> {//short
            Snackbar.make(this, message, Snackbar.LENGTH_LONG)
        }
    }

    action?.let {
        snackbar.setAction("Retry") {
            it()
        }
    }
    snackbar.apply {
        setBackgroundTint(ContextCompat.getColor(context, R.color.black))
        setTextColor(Color.WHITE)
        setActionTextColor(ContextCompat.getColor(context, R.color.purple_200))
        animationMode = ANIMATION_MODE_SLIDE
        show()
    }

}

