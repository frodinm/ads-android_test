package com.frodinm.ads_android_test.ui.capture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.frodinm.ads_android_test.R
import com.frodinm.ads_android_test.databinding.ChildTimeCaptureFragBinding
import com.frodinm.ads_android_test.databinding.TimeCaptureFragBinding
import com.frodinm.ads_android_test.ui.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class ChildTimeCaptureFragment: BaseFragment() {

    private val viewModel: TimeCaptureViewModel by viewModel()
    private lateinit var binding: ChildTimeCaptureFragBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ChildTimeCaptureFragBinding.inflate(inflater,container,false)
        binding.vm = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        handleViewModelEvents()
    }

    private fun handleViewModelEvents() {
        viewModel.run {
            refreshedTimeStampsEvent.observe(viewLifecycleOwner, { event ->
                event.getContentIfNotHandled()?.let {
                    showToast(R.string.updated)
                }
            })
        }
    }



}