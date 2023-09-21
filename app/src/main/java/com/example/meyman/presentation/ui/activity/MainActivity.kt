package com.example.meyman.presentation.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.example.meyman.R
import com.example.meyman.data.remote.dtos.auth.token.RefreshTokenDto
import com.example.meyman.data.remote.preferences.UserDataPreferencesHelper
import com.example.meyman.databinding.ActivityMainBinding
import com.example.meyman.presentation.base.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userPreferencesData: UserDataPreferencesHelper
    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        refreshAccessToken()
        setupNavController()

    }

    private fun refreshAccessToken() {
        val executor = Executors.newScheduledThreadPool(1)
        executor.scheduleAtFixedRate({
            Log.e("Masia", "refreshAccessToken: + ${userPreferencesData.accessToken} + ${userPreferencesData.refreshToken}", )
            if (userPreferencesData.isAuthorized) {
                lifecycleScope.launchWhenStarted {
                    val token = RefreshTokenDto(userPreferencesData.refreshToken)
                    viewModel.getToken( "Bearer ${userPreferencesData.accessToken}" ,token).collect { it ->
                        when (it) {
                            is Resource.Error -> {
                                Log.e("shug", "getNewToken: error ${it.message}")
                            }

                            is Resource.Loading -> {
                                Log.e("shug", "getNewToken: loading token")
                            }

                            is Resource.Success -> {
                                userPreferencesData.accessToken = it.data!!.access
                                Log.e("RT", "id: ${userPreferencesData.refreshToken}")
                            }
                        }
                    }
                }
            }
        }, 0, 20, TimeUnit.MINUTES)
    }

    private fun setupNavController() {
        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.mobile_navigation)

        if (!userPreferencesData.saveOnBoard) {
            navGraph.setStartDestination(R.id.onBoardFragment)
            binding.bottomNavigation.visibility = View.GONE
        } else {
            navGraph.setStartDestination(R.id.homeFragment)
            binding.bottomNavigation.visibility = View.VISIBLE
        }

        navController.graph = navGraph
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.onBoardFragment) {
                binding.bottomNavigation.visibility = View.GONE
            } else {
                binding.bottomNavigation.visibility = View.VISIBLE
            }
        }

        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    navController.navigate(R.id.homeFragment)
                    true
                }

                R.id.navigation_favorite -> {
                    navController.navigate(R.id.favoriteFragment)
                    true
                }

                R.id.navigation_booking -> {
                    navController.navigate(R.id.reservationFragment)
                    true
                }

                R.id.navigation_prof -> {
                    if (userPreferencesData.isAuthorized == true) {
                        navController.navigate(R.id.userProfileFragment)
                    } else {
                        navController.navigate(R.id.guestProfileFragment)

                    }
                    true
                }

                // Добавьте обработку других элементов нижней навигации, если необходимо

                else -> false
            }
        }
    }
}