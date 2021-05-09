package com.example.mvvmcoroutinesnetworkcall

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcoroutinesnetworkcall.R
import com.example.mvvmcoroutinesnetworkcall.databinding.FragmentCountBinding


class Count : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    lateinit var binding : FragmentCountBinding
    private lateinit var viewModel: TapViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding =  DataBindingUtil.inflate(inflater,
            R.layout.fragment_count,container, false)


        viewModel = ViewModelProvider(this).get(TapViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.taps.value = "0 taps"
        binding.tap.setOnClickListener {
            Log.e("TAG", "onCreateView: ")
            onTap()
        }

        return binding.root

    }

    private fun onTap(){
        viewModel.updateTaps()
    }
    companion object {


        @JvmStatic
        fun newInstance() = Count().apply {  }
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}