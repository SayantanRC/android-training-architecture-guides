package com.example.architectureguides

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.mvc_button).setOnClickListener {

        }

        findViewById<Button>(R.id.mvi_button).setOnClickListener {

        }

        findViewById<Button>(R.id.mvp_button).setOnClickListener {

        }

        findViewById<Button>(R.id.mvvm_button).setOnClickListener {

        }

    }
}