package com.example.cstech.model

import com.example.cstech.data.DonutData
import retrofit2.Callback

interface DonutDetailsRepository {
    fun getDonutDetails(callback: Callback<DonutData>)
}

class DonutDetailsRepositoryImpl() : DonutDetailsRepository {

    private val donutApiService: DonutApi = retrofit.create(DonutApi::class.java)

    override fun getDonutDetails(callback: Callback<DonutData>) {
        donutApiService.getDonutDetails().enqueue(callback)
    }
}
