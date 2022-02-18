package com.example.projectdia.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.projectdia.R
import com.example.projectdia.databinding.ActivityMenuBinding
import com.example.projectdia.fragment.*

class MenuActivity : AppCompatActivity() {
    lateinit var binding: com.example.projectdia.databinding.ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentt: Fragment = HomeFragment()
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content, fragmentt).commit()
        binding.navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menuOne -> {
                    val fragment: Fragment = HomeFragment()
                    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.content, fragment).commit()
                    true
                }
                R.id.menuMovie -> {
                    val fragment: Fragment = MovieFragment()
                    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.content, fragment).commit()
                    true
                }
                R.id.menuTwo -> {
                    val fragment: Fragment = ApplicationFragment()
                    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.content, fragment).commit()
                    true
                }
                R.id.menuThree -> {
                    val fragment: Fragment = ProfileFragment()
                    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.content, fragment).commit()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
}