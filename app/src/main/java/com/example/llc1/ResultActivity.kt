package com.example.llc1

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class ResultActivity : ComponentActivity(){

    private var initialBal = 0
    private var currYear = 0
    private var deathYear = 0
    private var val4 = 0
    private var val5 = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)

        initialBal = intent.getIntExtra("initialBal", 0)
        currYear = intent.getIntExtra("currYear", 0)
        deathYear = intent.getIntExtra("deathYear", 0)
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
        intent.putExtra("initialBal", initialBal)
        intent.putExtra("currYear", currYear)
        intent.putExtra("deathYear", deathYear)
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
        val initialBalView = findViewById<TextView>(R.id.val1TextView)
        val currYearView = findViewById<TextView>(R.id.val2TextView)
        val deathYearView = findViewById<TextView>(R.id.val3TextView)
        val v4 = findViewById<TextView>(R.id.val4TextView)
        val v5 = findViewById<TextView>(R.id.val5TextView)

        initialBalView.text = initialBal.toString()
        currYearView.text = currYear.toString()
        deathYearView.text = deathYear.toString()
        v4.text = val4.toString()
        v5.text = val5.toString()
    }
}