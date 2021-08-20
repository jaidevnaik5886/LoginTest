package com.jaidev.srijan.ui.signin

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jaidev.srijan.MainCoroutineRule
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SignInViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private lateinit var viewModel: SignInViewModel

    @Before
    fun setup() {
        viewModel = SignInViewModel()
    }

    @Test
    fun `check if it allows login without username and password`() {
        viewModel.onLoginClicked()
        val token = viewModel.token
        assertEquals("", token)
    }

    @Test
    fun `check login`() {
        viewModel.username.postValue("abc")
        viewModel.password.postValue("pass")
        viewModel.onLoginClicked()
        val token = viewModel.token
        assertEquals("loggedIn", token)
    }

}