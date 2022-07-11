package com.example.contextualcards.network

import com.example.contextualcards.models.APIResponse
import retrofit2.http.GET
import retrofit2.Call

interface Service {

    @GET("/efcfbeb-5c12-4722-94ad-b8f92caad1ad")
    fun getResponse(): Call<APIResponse>
}