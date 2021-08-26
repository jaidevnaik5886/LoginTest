package com.jaidev.srijan.ui.signin

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.jaidev.srijan.R
import com.jaidev.srijan.base.BaseActivity
import com.jaidev.srijan.base.BaseFragment
import com.jaidev.srijan.base.BaseViewModel
import com.jaidev.srijan.databinding.FragmentLoginBinding
import com.jaidev.srijan.utils.BaseEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {

    val model: SignInViewModel by viewModels()

    override fun attachBinding() {
        binding.handler = this
        binding.vm = model
        model.loginMediator.observe(viewLifecycleOwner, {
            binding.btnLogin.isEnabled = it
        })
    }

    override fun getVM(): BaseViewModel = model

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity is BaseActivity<*>) {
            (activity as BaseActivity<*>).supportActionBar?.hide()
        }
    }


    override fun handleEvent(event: BaseEvent) {
        super.handleEvent(event)
        when (event) {
            is NavToHomePage -> {
                findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToHomeFragment(event.username))
            }
        }
    }

}