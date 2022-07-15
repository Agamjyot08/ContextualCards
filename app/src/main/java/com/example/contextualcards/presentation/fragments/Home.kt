package com.example.contextualcards.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contextualcards.R
import com.example.contextualcards.adapter.NestedHomeAdapter
import com.example.contextualcards.data.Resource
import com.example.contextualcards.databinding.FragmentHomeBinding
import com.example.contextualcards.models.CardGroup
import com.example.contextualcards.presentation.viewmodel.ViewModel
import com.example.contextualcards.utils.CShowProgress
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class Home : Fragment(R.layout.fragment_home) {

    private var binding: FragmentHomeBinding? = null
    private val viewModel: ViewModel by viewModels()
    @Inject
    lateinit var progress: CShowProgress
    private var ReAdapter : NestedHomeAdapter? = null
    private var list : ArrayList<CardGroup> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ReAdapter = NestedHomeAdapter(list)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        setupObservable()
        Apicall()
    }

    private fun Apicall() {
        viewModel.login()
    }

    private fun setupObservable() {
        lifecycleScope.launch {
            viewModel.getDataRes.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED).collect{
                when (it) {
                    is Resource.Success -> {
                        hideProgress()
                        try {
                            list.addAll(it.value.card_groups)
                            Log.d("LogTag", list.toString())
                            binding?.contextualCard?.recycler?.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                            binding?.contextualCard?.recycler?.adapter = ReAdapter
                        } catch (e: Exception) {
                            Toast.makeText(requireContext(), "oops..! Something went wrong.", Toast.LENGTH_SHORT).show()
                        }
                    }
                    is Resource.Failure ->{
                        hideProgress()

                    }
                    is Resource.Loading ->{
                        showprogress()
                    }
                    else -> {}
                }
            }
        }

    }

    fun showprogress(){
        if(progress.mDialog?.isShowing == true){
            progress.hideProgress()
        }else{
            progress.showProgress(requireContext())
        }
    }

    fun hideProgress(){
        progress.hideProgress()
    }
}