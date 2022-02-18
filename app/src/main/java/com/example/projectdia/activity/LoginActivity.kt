package com.example.projectdia.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.projectdia.databinding.ActivityLoginBinding
import com.example.projectdia.databinding.ActivitySignupBinding
import com.example.projectdia.model.requestlogin.RequestLogin
import com.example.projectdia.viewmodel.LoginViewModel


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnLogin.setOnClickListener {
            viewModel.postLogin(
                RequestLogin(
                    binding.etEmail.text.toString(),
                    binding.etPassword.text.toString()
                )
            )

//            val username = binding.etUsername.text.toString()
//            val password = binding.etPassword.text.toString()
//            Prefs.putString(PrefsKeys.USERNAME, username)
//            Prefs.putString(PrefsKeys.PASSWORD, password)
//            Prefs.putBoolean(PrefsKeys.IS_LOGIN, true)
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
        }
        setObserver()

        binding.tvSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

    }

    private fun setObserver() {
        viewModel.listResponse().observe(this, Observer {
            val intent = Intent(this, JobActivity::class.java)
            intent.putExtra("id", it.data.userId.toString())
            intent.putExtra("name", it.data.userName.toString())
            intent.putExtra("email", it.data.userEmail.toString())
            startActivity(intent)
        })
        viewModel.getIsError().observe(this, Observer {
            if (it) {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        })
    }

}