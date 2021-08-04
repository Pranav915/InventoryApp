package com.iiti.inventoryapp


import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.iiti.inventoryapp.databinding.ActivityMainBinding
import com.iiti.inventoryapp.ui.requests.RequestsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navController: NavController
    private lateinit var appBarConfig: AppBarConfiguration
    private lateinit var navView:NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.topAppBar))

        drawerLayout = binding.drawerLayout
        navView = binding.navView
        navController = this.findNavController(R.id.nav_host_fragment_activity_main)

        binding.bottomNavView.setupWithNavController(navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        appBarConfig = AppBarConfiguration(navController.graph, drawerLayout)

        // lock drawer when not in start destination
        navController.addOnDestinationChangedListener { nc, nd, _ ->

            if (nd.id == nc.graph.startDestination) {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            } else {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
        }

        NavigationUI.setupWithNavController(binding.navView, navController)

        navView.menu.findItem(R.id.settings).setOnMenuItemClickListener {
            val dialogIntent = Intent(Settings.ACTION_SETTINGS)
            dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(dialogIntent)
            true
        }

        navView.menu.findItem(R.id.logOut).setOnMenuItemClickListener {
            startActivity(Intent(this , LoginPage::class.java ))
            finish()
            true
        }


    }

    override fun onSupportNavigateUp(): Boolean {

        // replace navigation up button with nav drawer button when on start destination
        return NavigationUI.navigateUp(navController, appBarConfig)

    }
}

