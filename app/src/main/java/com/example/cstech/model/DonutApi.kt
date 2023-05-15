package com.example.cstech.model

import com.example.cstech.data.DonutData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// https://android-interview.s3.eu-west-2.amazonaws.com/endpoint.json

interface DonutApi {
    @GET("endpoint.json")
    fun getDonutDetails(): Call<DonutData>
}

val retrofit by lazy {
    Retrofit.Builder()
        .baseUrl("https://android-interview.s3.eu-west-2.amazonaws.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}
