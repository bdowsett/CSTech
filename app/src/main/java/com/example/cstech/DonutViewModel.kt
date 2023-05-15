package com.example.cstech

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cstech.data.DonutData
import com.example.cstech.model.DonutDetailsRepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DonutViewModel : ViewModel() {

    private val donutRepo = DonutDetailsRepositoryImpl()
    private val _donutData = MutableLiveData<DonutData>()
    val donutData: MutableLiveData<DonutData>
        get() = _donutData

    init {
        getDonutDetails()
    }

    fun getDonutDetails() {
        donutRepo.getDonutDetails(object : Callback<DonutData> {
            override fun onResponse(call: Call<DonutData>, response: Response<DonutData>) {
                if (response.isSuccessful) {
                    _donutData.value = response.body()
                } else {
                    // nothing
                } }

            override fun onFailure(call: Call<DonutData>, t: Throwable) {
                Log.d("Response", t.message.toString())
            }
        })
    }
}
