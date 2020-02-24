package com.debcomp.aql.olhaachuva.ui.week.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.debcomp.aql.olhaachuva.R

class WeekDetailFragment : Fragment() {

    companion object {
        fun newInstance() =
            WeekDetailFragment()
    }

    private lateinit var viewModel: WeekDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.week_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(
            WeekDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
