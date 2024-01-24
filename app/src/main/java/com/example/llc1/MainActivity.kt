package com.example.llc1

import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.llc1.model.Model

class MainActivity : ComponentActivity(){

    private lateinit var model : Model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        model = Model(0, 0, 0, 0, 0)

        val confirmButton = findViewById<Button>(R.id.confirmButton)
        confirmButton.setOnClickListener{
            updateVals()
        }
    }

    private fun updateVals(){
        val edit1 = findViewById<EditText>(R.id.edit1)

        // ====== SCRUB INPUT ========

        val val1 : Int = edit1.text.toString().toInt()
        model.setVal1(val1)

        val t = findViewById<TextView>(R.id.textView2)
        t.text = model.getVal1().toString()
    }
}