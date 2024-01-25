package com.example.llc1

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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
        val edit2 = findViewById<EditText>(R.id.edit2)
        val edit3 = findViewById<EditText>(R.id.edit3)
        val edit4 = findViewById<EditText>(R.id.edit4)
        val edit5 = findViewById<EditText>(R.id.edit5)

        val val1 : String = edit1.text.toString()
        val val2 : String = edit1.text.toString()
        val val3 : String = edit1.text.toString()
        val val4 : String = edit1.text.toString()
        val val5 : String = edit1.text.toString()

        if(val1 != "" && val2 != "" && val2 != ""
            && val4 != "" && val5 != ""){
            model.setVal1(val1.toInt())
            model.setVal2(val2.toInt())
            model.setVal3(val3.toInt())
            model.setVal4(val4.toInt())
            model.setVal5(val5.toInt())

            startResultActivity()
        } else{
            showWarnToast()
        }

    }

    private fun showWarnToast(){
        val message = "Please fill in all fields"
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun startResultActivity(){
        val intent = Intent(this, ResultActivity::class.java)
        startActivity(intent)
    }
}