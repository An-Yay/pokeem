package com.example.pokeem

import `in`.stcvit.idcard.ui.fragments.ProfileFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.pokeem.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class  MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.resources.getColor(R.color.primBg)
        replaceFragement(HomeFragment())
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home ->replaceFragement(HomeFragment())
                R.id.profile -> replaceFragement(ProfileFragment())
                R.id.group -> replaceFragement(GroupFragment())
                R.id.list -> replaceFragement(AppFragment())
                R.id.rank -> replaceFragement(LeaderFragment())
                else ->
                {

                }
            }
            true

        }





    }
    private fun replaceFragement(fragment : Fragment){
        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.coordinator,fragment)
        fragmentTransaction.commit()


    }
}