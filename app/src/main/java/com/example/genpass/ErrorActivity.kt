package com.example.genpass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ErrorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)
        supportActionBar?.hide()
    }
}