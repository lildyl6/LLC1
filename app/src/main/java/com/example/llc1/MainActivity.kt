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
            if(updateVals()){
                model.doCalc(1950, 1)
                startResultActivity()
            }
        }
    }

    private fun updateVals() : Boolean{
        val initialBalEdit = findViewById<EditText>(R.id.initialBalEdit)
        val currYearEdit = findViewById<EditText>(R.id.currYearEdit)
        val deathYearEdit = findViewById<EditText>(R.id.deathYearEdit)
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

            return true
        } else{
            showWarnToast()
            return false
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
        val initialBal = intent.getFloatExtra("initialBal", -1f)
        val currYear = intent.getIntExtra("currYear", -1)
        val deathYear = intent.getIntExtra("deathYear", -1)
        val val4 = intent.getIntExtra("val4", -1)
        val val5 = intent.getIntExtra("val5", -1)
        var changed = false

        if(initialBal != -1f) {
            model.setInitialBal(initialBal)
            changed = true
        }
        if(currYear != -1) {
            model.setCurrYear(currYear)
            changed = true
        }
        if(deathYear != -1) {
            model.setDeathYear(deathYear)
            changed = true
        }
        /*
        if(val4 != -1) {
            model.setVal4(val4)
        }
        if(val5 != -1) {
            model.setVal5(val5)
        }
        */

        if(changed) {
            setViews()
        }
    }

    private fun setViews(){
        var x = findViewById<EditText>(R.id.initialBalEdit)
        x.setText(model.getInitialBal().toString())
        x = findViewById(R.id.currYearEdit)
        x.setText(model.getCurrYear().toString())
        x = findViewById(R.id.deathYearEdit)
        x.setText(model.getDeathYear().toString())
        /*
        x = findViewById(R.id.edit4)
        x.setText(model.getVal4().toString())
        x = findViewById(R.id.edit5)
        x.setText(model.getVal5().toString())
        */
    }
}