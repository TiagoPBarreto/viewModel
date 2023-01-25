package com.teste.viewmodel

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    var count = 0
    private lateinit var viewModel: MainViewModel
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val textView = findViewById<TextView>(R.id.textAcount)
        val button = findViewById<Button>(R.id.btnCount)

        //textView.text = count.toString()
       // textView.text = viewModel.count.toString()
        viewModel.count.observe(
            this,
        ) {
            textView.text = it.toString()
        }

        button.setOnClickListener {
           // ++count
           // textView.text = count.toString()
            viewModel.updateCount()
           // textView.text = viewModel.count.toString()
        }
    }
}