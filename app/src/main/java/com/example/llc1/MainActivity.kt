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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val confirmButton = findViewById<Button>(R.id.confirmButton)
        confirmButton.setOnClickListener{
            if(updateVals()){
                Model.doCalc(1950, 1)
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
            Model.initialBal = initialBal.toFloat()
            Model.currYear = currYear.toInt()
            Model.deathYear = deathYear.toInt()
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
        val animBundle = ActivityOptions.makeCustomAnimation(
            this,
            R.anim.fade_in,
            R.anim.fade_out
        ).toBundle()

        startActivity(intent, animBundle)
    }

    private fun setViews(){
        var x = findViewById<EditText>(R.id.initialBalEdit)
        x.setText(Model.initialBal.toString())
        x = findViewById(R.id.currYearEdit)
        x.setText(Model.currYear.toString())
        x = findViewById(R.id.deathYearEdit)
        x.setText(Model.deathYear.toString())
        /*
        x = findViewById(R.id.edit4)
        x.setText(model.getVal4().toString())
        x = findViewById(R.id.edit5)
        x.setText(model.getVal5().toString())
        */
    }
}