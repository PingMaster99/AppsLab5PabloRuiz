package com.example.zvent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.zvent.databinding.ActivityMainBinding
/**
 * <h1>MainActivity</h1>
 *<p>
 * Main activity that runs all the fragments of Zvent guest register app
 *</p>
 *
 * @author Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-04-26
 **/
class MainActivity : AppCompatActivity() {
    // Drawer layout
    private lateinit var drawerLayout: DrawerLayout

    /**
     * Builds the app initialization displays the information requested
     * @param savedInstanceState saved App data
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Data binding
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        drawerLayout = binding.drawerLayout     // Initializes the drawer layout

        // navCOntroller used in the start fragment
        val navController = this.findNavController(R.id.navStart)

        // Setup of the navigation drawer
        NavigationUI.setupActionBarWithNavController(this,navController, drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)
    }

    /**
     * Adds functionality to the hamburger icon
     * @return Boolean
     */
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.navStart)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}
