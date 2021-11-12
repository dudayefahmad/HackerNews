package com.ahmaddudayef.hackernews.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ahmaddudayef.hackernews.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}