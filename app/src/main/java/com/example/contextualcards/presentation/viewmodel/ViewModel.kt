package com.example.contextualcards.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contextualcards.data.Resource
import com.example.contextualcards.models.APIResponse
import com.example.contextualcards.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModel @Inject constructor(private var repository: Repository) : ViewModel() {

    private val _getDataRes = MutableStateFlow<Resource<APIResponse>>(Resource.Initial)
    val getDataRes: StateFlow<Resource<APIResponse>> = _getDataRes.asStateFlow()

    fun login() = viewModelScope.launch {
        _getDataRes.value = Resource.Loading
        _getDataRes.value = repository.getUser()
    }

}