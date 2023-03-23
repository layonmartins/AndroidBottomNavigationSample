package com.example.androidbottomnavigationsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.androidbottomnavigationsample.fragments.CarFragment
import com.example.androidbottomnavigationsample.fragments.HomeFragment
import com.example.androidbottomnavigationsample.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setNavBottomNavigation()
        setupBadge()
    }

    private fun setNavBottomNavigation() {
        loadFragment(HomeFragment())
        bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.car -> {
                    loadFragment(CarFragment())
                    bottomNav.removeBadge(R.id.car)
                    true
                }
                R.id.settings -> {
                    loadFragment(ProfileFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun setupBadge() {
        var badge = bottomNav.getOrCreateBadge(R.id.car)
        badge.isVisible = true
        // An icon only badge will be displayed unless a number is set:
        badge.number = 11
    }

    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }

    fun hideNavigation(show: Boolean? = null) {
        if(show == null) {
            bottomNav.isVisible = !bottomNav.isVisible
        } else {
            bottomNav.isVisible = show
        }
    }
}