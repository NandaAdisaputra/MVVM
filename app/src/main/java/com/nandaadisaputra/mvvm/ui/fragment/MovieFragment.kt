package com.nandaadisaputra.mvvm.ui.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.nandaadisaputra.mvvm.R
import com.nandaadisaputra.mvvm.adapter.MovieAdapter
import com.nandaadisaputra.mvvm.model.ResultsItem
import com.nandaadisaputra.mvvm.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie.*


class MovieFragment : Fragment() {

    private lateinit var viewModel: MovieViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        viewModel.getStatus().observe(this, Observer {
                t ->
            if(t != false){
                list.visibility = View.GONE
                textStatus.visibility = View.VISIBLE
            }else {
                list.visibility = View.VISIBLE
                textStatus.visibility = View.GONE
            }

        })

        viewModel.setData().observe(this, Observer {
                t ->
            t?.results?.let(this::showData)
        })
    }

    private fun showData(data: List<ResultsItem?>) {
        list.adapter = MovieAdapter(data)

    }

}
