package com.example.meyman.presentation.ui.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.meyman.R
import com.example.meyman.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    navController.navigate(R.id.homeFragment) // ID вашего фрагмента 1
                    true
                }

                R.id.navigation_favorite -> {
                    navController.navigate(R.id.favoriteFragment) // ID вашего фрагмента 1
                    true
                }

                R.id.navigation_booking -> {
                    navController.navigate(R.id.roomBookingFragment) // ID вашего фрагмента 1
                    true
                }

                R.id.navigation_prof -> {
                    navController.navigate(R.id.guestProfileFragment) // ID вашего фрагмента 2
                    true
                }
                // Добавьте обработку других элементов нижней навигации, если необходимо
                else -> false
            }
        }
    }
}
