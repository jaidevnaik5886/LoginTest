package com.jaidev.srijan.ui.home

import androidx.fragment.app.viewModels
import com.jaidev.srijan.R
import com.jaidev.srijan.base.BaseFragment
import com.jaidev.srijan.base.BaseViewModel
import com.jaidev.srijan.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentBinding>(R.layout.home_fragment, R.string.home) {

    val model: HomeViewModel by viewModels()

    override fun getVM(): BaseViewModel = model

    override fun attachBinding() {

    }


}