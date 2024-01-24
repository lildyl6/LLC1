package com.example.llc1

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.llc1.model.Model

class MainActivity : ComponentActivity(){

    private lateinit var model : Model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        model = Model(0, 0, 0, 0, 0)
    }
}