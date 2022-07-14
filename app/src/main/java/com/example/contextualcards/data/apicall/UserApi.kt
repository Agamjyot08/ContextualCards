package com.example.contextualcards.data.apicall

import com.example.contextualcards.models.APIResponse
import retrofit2.http.GET

interface UserApi {

    @GET("fefcfbeb-5c12-4722-94ad-b8f92caad1ad")
    suspend fun getdata(): APIResponse

}