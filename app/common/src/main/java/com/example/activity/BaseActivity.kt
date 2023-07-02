package com.example.activity

import android.os.Bundle
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.common.R

abstract class BaseActivity: AppCompatActivity() {

    protected val architectureName by lazy { findViewById<TextView>(R.id.architecture_name) }
    protected val resultTextView by lazy { findViewById<TextView>(R.id.number_display) }
    protected val loadingBar by lazy { findViewById<ProgressBar>(R.id.loading_bar) }
    protected val countInput by lazy { findViewById<EditText>(R.id.count_input) }
    protected val okButton by lazy { findViewById<TextView>(R.id.ok_button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_layout)
    }
}