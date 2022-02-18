package com.example.projectdia.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectdia.adapter.JobAdapter
import com.example.projectdia.databinding.ActivityJobBinding
import com.example.projectdia.model.getalljob.Data
import com.example.projectdia.viewmodel.JobViewModel

class JobActivity : AppCompatActivity() {
    lateinit var binding: ActivityJobBinding
    private val adapter = JobAdapter()
    private val viewModel: JobViewModel by lazy {
        ViewModelProviders.of(this).get(JobViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val layoutManager = LinearLayoutManager(this)
        binding.rvHasil.layoutManager = layoutManager
        viewModel.getAllJob()
        setObserver()
    }

    private fun setObserver(){
        viewModel.listResponse().observe(this, Observer {
            binding.rvHasil.adapter = adapter
            Log.d("listapp", "if22")
            adapter.initData(it.data as ArrayList<Data>)
        })
    }
}