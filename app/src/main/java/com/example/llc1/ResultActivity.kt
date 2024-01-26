package com.example.llc1

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class ResultActivity : ComponentActivity(){

    private var val1 = 0
    private var val2 = 0
    private var val3 = 0
    private var val4 = 0
    private var val5 = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)

        val1 = intent.getIntExtra("val1", 0)
        val2 = intent.getIntExtra("val2", 0)
        val3 = intent.getIntExtra("val3", 0)
        val4 = intent.getIntExtra("val4", 0)
        val5 = intent.getIntExtra("val5", 0)

        val goBackButton = findViewById<Button>(R.id.goBackButton)
        goBackButton.setOnClickListener{
            startMainActivity()
        }

        //testing
        setViews()

    }

    private fun startMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("val1", val1)
        intent.putExtra("val2", val2)
        intent.putExtra("val3", val3)
        intent.putExtra("val4", val4)
        intent.putExtra("val5", val5)

        val animBundle = ActivityOptions.makeCustomAnimation(
            this,
            R.anim.fade_in,
            R.anim.fade_out
        ).toBundle()

        startActivity(intent, animBundle)
    }

    //testing
    private fun setViews(){
        val v1 = findViewById<TextView>(R.id.val1TextView)
        val v2 = findViewById<TextView>(R.id.val2TextView)
        val v3 = findViewById<TextView>(R.id.val3TextView)
        val v4 = findViewById<TextView>(R.id.val4TextView)
        val v5 = findViewById<TextView>(R.id.val5TextView)

        v1.text = val1.toString()
        v2.text = val2.toString()
        v3.text = val3.toString()
        v4.text = val4.toString()
        v5.text = val5.toString()
    }
}