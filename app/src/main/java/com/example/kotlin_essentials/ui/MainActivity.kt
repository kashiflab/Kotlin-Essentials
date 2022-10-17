package com.example.kotlin_essentials.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlin_essentials.MyApp
import com.example.kotlin_essentials.databinding.ActivityMainBinding
import com.example.kotlin_essentials.ui.adapter.ShowAdapter
import com.example.kotlin_essentials.ui.viewmodel.MainViewModel
import com.example.kotlin_essentials.ui.viewmodel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as MyApp).appComponent.inject(this)

        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

        binding.recyclerView.layoutManager = GridLayoutManager(this,2)

        mainViewModel.shows.observe(this, Observer {
            val adapter = ShowAdapter(this,it)
            binding.recyclerView.adapter = adapter
        })
    }
}