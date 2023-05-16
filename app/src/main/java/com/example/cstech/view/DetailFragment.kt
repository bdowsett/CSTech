package com.example.cstech.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.cstech.R
import com.example.cstech.data.CreditReportInfo

class DetailFragment : Fragment() {

    private val detailViewModel: DetailViewModel by viewModels()

    private lateinit var title: TextView
    private lateinit var shortTerm: TextView
    private lateinit var longTerm: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val data: CreditReportInfo? = arguments?.getParcelable("credit_Report_Info")
        if (data != null) {
            detailViewModel.setData(data)
        }
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(
            view,
            savedInstanceState,
        )
        title = view.findViewById(R.id.title)
        shortTerm = view.findViewById(R.id.short_term_debt)
        longTerm = view.findViewById(R.id.long_term_debt)

        detailViewModel.detailData.observe(viewLifecycleOwner) {
            val shortTermDebt = it.currentShortTermDebt.toString()
            val longTermDebt = it.currentLongTermDebt.toString()

            shortTerm.text = getString(R.string.your_short_term_debt_is, shortTermDebt)
            longTerm.text = getString(R.string.your_long_term_debt_is, longTermDebt)
        }
    }
}
