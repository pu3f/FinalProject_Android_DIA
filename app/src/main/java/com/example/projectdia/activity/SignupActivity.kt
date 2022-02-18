package com.example.projectdia.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.projectdia.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cvSatu.setOnClickListener {
            if (binding.etPin.text.toString() == "123") {
                val intent = Intent(this, Class.forName("com.example.projectdia.activity.LoginActivity"))
                this.startActivity(intent)
            } else {
                Toast.makeText(this, "Pin Salah", Toast.LENGTH_SHORT).show()
            }
        }

        binding.cvSatu.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}