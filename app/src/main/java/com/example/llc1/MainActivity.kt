package com.example.llc1

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.llc1.model.Model

class MainActivity : ComponentActivity(){

    private lateinit var model : Model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        model = Model(0, 0, 0, 0, 0)
        var val1 : Int = 0
        val edit1 = findViewById<EditText>(R.id.edit1)
    }
}