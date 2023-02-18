package com.expv1n.mynewsapplication.ui.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.expv1n.mynewsapplication.R
import com.expv1n.mynewsapplication.databinding.ActivityMainBinding
import com.expv1n.mynewsapplication.ui.adapter.MainScreenAdapter
import com.expv1n.mynewsapplication.ui.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    private  val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }


}