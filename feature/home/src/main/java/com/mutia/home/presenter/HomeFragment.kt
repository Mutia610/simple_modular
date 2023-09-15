package com.mutia.home.presenter

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mutia.base.domain.subscribers.Resource
import com.mutia.base.utils.autoCleaned
import com.mutia.home.BR
import com.mutia.home.R
import com.mutia.home.adapter.HomeAdapter
import com.mutia.home.databinding.FragmentHomeBinding
import com.mutia.home.di.inject
import com.mutia.uicomponents.base.BaseFragment
import javax.inject.Inject

class HomeFragment() : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    override val binding: FragmentHomeBinding by autoCleaned {(FragmentHomeBinding.inflate(layoutInflater))}
    override val bindingVariable: Int = BR.vmHome
    override val viewModel: HomeViewModel by lazy { ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java] }

    private val homeAdapter: HomeAdapter by autoCleaned { HomeAdapter() }

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onStart() {
        super.onStart()
        viewModel.showToast.value = "Hooraayy"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject()
    }

    override fun setupAdapter() {
        super.setupAdapter()
        val linearLayout = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.rcvHome.layoutManager = linearLayout
        binding.rcvHome.itemAnimator = DefaultItemAnimator()
        binding.rcvHome.isNestedScrollingEnabled = false
        binding.rcvHome.setHasFixedSize(true)
        binding.rcvHome.adapter = homeAdapter
    }

    override fun setupObserver() {
        super.setupObserver()
        viewModel.getSourceLliveData.asLiveData().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {  }
                is Resource.Success -> {
                    hideLoading()
                    it.data?.let { res ->
                        homeAdapter.setData(res.sources)
                    }
                }
                is Resource.Failure -> {
                    hideLoading()
//                    showDialogNetworkErrorSheet(
//                        isCallback = false, isCancelable = true,
//                        fragmentManager = parentFragmentManager, resTargetCode = null,
//                        failure = it.failureData
//                    )
                } else -> {}
            }
        }
    }

    override fun initAPI() {
        super.initAPI()
        viewModel.getSourceList()
    }
}