package com.example.projectdia.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.projectdia.R
import com.example.projectdia.databinding.ActivitySplashScreenBinding
import com.example.projectdia.utils.PrefsKeys
import com.pixplicity.easyprefs.library.Prefs

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            this.startActivity(intent)
//            val isLogin = Prefs.getBoolean(PrefsKeys.IS_LOGIN, false)
//            if (isLogin) {
//                val intent = Intent(this, MenuActivity::class.java)
//                this.startActivity(intent)
//            } else {
//                val intent = Intent(this, LoginActivity::class.java)
//                this.startActivity(intent)
//            }
        },3000)
    }
}