package com.example.meyman.presentation.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.example.meyman.R
import com.example.meyman.data.remote.preferences.UserDataPreferencesHelper
import com.example.meyman.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userPreferencesData: UserDataPreferencesHelper
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavController()

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
                    navController.navigate(R.id.roomBookingFragment)
                    true
                }

                R.id.navigation_prof -> {
                    navController.navigate(R.id.guestProfileFragment)
                    true
                }

                // Добавьте обработку других элементов нижней навигации, если необходимо

                else -> false
            }
        }
    }
}