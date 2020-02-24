package com.debcomp.aql.olhaachuva.ui.week.list

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.debcomp.aql.olhaachuva.R

class WeekListFragment : Fragment() {

    companion object {
        fun newInstance() =
            WeekListFragment()
    }

    private lateinit var viewModel: WeekListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.week_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(
            WeekListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
