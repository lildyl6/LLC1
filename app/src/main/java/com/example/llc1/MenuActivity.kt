package com.example.llc1

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class MenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_activity)

        val b = findViewById<Button>(R.id.button)
        b.setOnClickListener{
            finish()
        }
    }
}

