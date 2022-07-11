package com.example.contextualcards.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.contextualcards.repository.Repository

class ViewModel(
    app: Application,
    private val Repository: Repository
): AndroidViewModel(app) {

    fun Result() = Repository.result()
}