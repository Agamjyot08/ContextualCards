package com.example.contextualcards.repository

import com.example.contextualcards.data.apicall.SafeApiCall
import com.example.contextualcards.data.apicall.UserApi
import javax.inject.Inject

class Repository @Inject constructor(private val api: UserApi): SafeApiCall {

    suspend fun getUser() = safeApiCall {
        api.getdata()
    }
}