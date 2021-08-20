package com.jaidev.srijan

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.jaidev.srijan.base.BaseActivity
import com.jaidev.srijan.base.BaseViewModel
import com.jaidev.srijan.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main),
    NavController.OnDestinationChangedListener {


    override fun getVM(): BaseViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navController =
            (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(R.id.signInFragment, R.id.homeFragment),
            fallbackOnNavigateUpListener = ::onSupportNavigateUp
        )
        navController.addOnDestinationChangedListener(this)
        findViewById<Toolbar>(R.id.toolbar).apply {
            setUpToolbar(this)
        }.setupWithNavController(navController, appBarConfiguration)
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        when (destination.id) {
            R.id.signInFragment -> {
                supportActionBar?.hide()
            }
            else -> {
                supportActionBar?.show()
            }
        }
    }
}