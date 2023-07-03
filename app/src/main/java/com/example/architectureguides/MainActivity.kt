package com.example.architectureguides

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mvc.controller.MvcActivity
import com.example.mvp.view.MvpViewActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.mvc_button).setOnClickListener {
            startActivity(
                Intent(this, MvcActivity::class.java)
            )
        }

        findViewById<Button>(R.id.mvi_button).setOnClickListener {

        }

        findViewById<Button>(R.id.mvp_button).setOnClickListener {
            startActivity(
                Intent(this, MvpViewActivity::class.java)
            )
        }

        findViewById<Button>(R.id.mvvm_button).setOnClickListener {

        }

    }
}