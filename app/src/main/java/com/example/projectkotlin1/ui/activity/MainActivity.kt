package com.example.projectkotlin1.ui.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.projectkotlin1.App
import com.example.projectkotlin1.R
import com.example.projectkotlin1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        isShowFirstScreen()
    }

    private fun isShowFirstScreen() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)

        if(App.preferenceHelper.isShown()) {
            navGraph.setStartDestination(R.id.noteAppFragment)
        }else {
            navGraph.setStartDestination(R.id.onBoardFragment2)
        }
        navController.graph = navGraph
    }
}