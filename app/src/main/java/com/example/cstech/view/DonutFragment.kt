package com.example.cstech.view

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.cstech.DonutViewModel
import com.example.cstech.R

class DonutFragment : Fragment() {
    lateinit var donutScore: TextView
    lateinit var progressBar: ProgressBar
    lateinit var donut: FrameLayout

    private val donutViewModel: DonutViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_donut, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        donutScore = view.findViewById(R.id.score)
        progressBar = view.findViewById(R.id.progress)
        donut = view.findViewById(R.id.donut)

        var bundle: Bundle

        donutViewModel.donutData.observe(viewLifecycleOwner) {
            val score = it.creditReportInfo.score
            donutScore.text = score.toString()
            animateDonut(score.toInt())

            bundle = Bundle().apply {
                putParcelable(CREDIT_REPORT_INFO, it.creditReportInfo)
            }
        }

        donut.setOnClickListener {
                view ->
            view.findNavController().navigate(R.id.navigate_to_details)
        }
    }

    fun animateDonut(value: Int) {
        ObjectAnimator.ofInt(progressBar, "progress", value)
            .setDuration(1000)
            .start()
    }

    companion object {
        private const val CREDIT_REPORT_INFO = "credit_Report_Info"
    }
}
