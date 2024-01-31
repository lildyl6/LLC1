package com.example.llc1

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.llc1.model.Model

class MainActivity : ComponentActivity(){

    private lateinit var model : Model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        model = Model(0f, 0, 0,
            0, 0, 0)

        checkForExistingValues()

        val confirmButton = findViewById<Button>(R.id.confirmButton)
        confirmButton.setOnClickListener{
            updateVals()
            model.doCalc(1950, 1)
            startResultActivity()
        }
    }

    private fun updateVals(){
        val initialBalEdit = findViewById<EditText>(R.id.edit1)
        val currYearEdit = findViewById<EditText>(R.id.edit2)
        val deathYearEdit = findViewById<EditText>(R.id.edit3)
        val edit4 = findViewById<EditText>(R.id.edit4)
        val edit5 = findViewById<EditText>(R.id.edit5)

        val initialBal : String = initialBalEdit.text.toString()
        val currYear : String = currYearEdit.text.toString()
        val deathYear : String = deathYearEdit.text.toString()
        val val4 : String = edit4.text.toString()
        val val5 : String = edit5.text.toString()

        if(initialBal != "" && currYear != "" && deathYear != ""
            && val4 != "" && val5 != ""){
            model.setInitialBal(initialBal.toFloat())
            model.setCurrYear(currYear.toInt())
            model.setDeathYear(deathYear.toInt())
            /*
            model.setVal4(val4.toInt())
            model.setVal5(val5.toInt())
            */

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
        intent.putExtra("initialBal", model.getInitialBal())

        intent.putExtra("currYear", model.getCurrYear())
        intent.putExtra("deathYear", model.getDeathYear())
        /*
        intent.putExtra("val4", model.getVal4())
        intent.putExtra("val5", model.getVal5())
        */

        val animBundle = ActivityOptions.makeCustomAnimation(
            this,
            R.anim.fade_in,
            R.anim.fade_out
        ).toBundle()

        startActivity(intent, animBundle)
    }

    private fun checkForExistingValues(){
        val val1 = intent.getIntExtra("initialBal", -1)
        val val2 = intent.getIntExtra("currYear", -1)
        val val3 = intent.getIntExtra("deathYear", -1)
        val val4 = intent.getIntExtra("val4", -1)
        val val5 = intent.getIntExtra("val5", -1)

        //cheaty way to check all arent -1
        if(val1 + val2 + val3 + val4 + val5 != -5){
            model.setInitialBal(val1.toFloat())
            model.setCurrYear(val2)
            model.setDeathYear(val3)
            /*
            model.setVal4(val4)
            model.setVal5(val5)
            */

            setViews()
        }
    }

    private fun setViews(){
        var x = findViewById<EditText>(R.id.edit1)
        x.setText(model.getInitialBal().toString())
        x = findViewById(R.id.edit2)
        x.setText(model.getCurrYear().toString())
        x = findViewById(R.id.edit3)
        x.setText(model.getDeathYear().toString())
        /*
        x = findViewById(R.id.edit4)
        x.setText(model.getVal4().toString())
        x = findViewById(R.id.edit5)
        x.setText(model.getVal5().toString())
        */
    }
}