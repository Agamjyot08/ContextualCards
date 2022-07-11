package com.example.contextualcards.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.contextualcards.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import com.example.contextualcards.models.APIResponse
import retrofit2.Response

class Repository {

    private val service = RetrofitInstance.apiService
    private val response: MutableLiveData<APIResponse> = MutableLiveData()

    init {
        getResponse()
    }

    private fun getResponse() {
        service.getResponse().enqueue(
            object : Callback<APIResponse> {
                override fun onResponse(call: Call<APIResponse>, response: Response<APIResponse>) {

                }

                override fun onFailure(call: Call<APIResponse>, t: Throwable) {

                    Log.e("api error", "onFailure: ${t.message}")
                }
            }
        )
    }

        fun result(): LiveData<APIResponse>{
            return response
        }

}