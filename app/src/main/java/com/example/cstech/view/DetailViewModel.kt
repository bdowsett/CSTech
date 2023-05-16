package com.example.cstech.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cstech.data.CreditReportInfo

class DetailViewModel : ViewModel() {

    private val _detailData = MutableLiveData<CreditReportInfo>()
    val detailData: MutableLiveData<CreditReportInfo>
        get() = _detailData

    fun setData(data: CreditReportInfo) {
        detailData.value = data
    }
}
