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

        model = Model(0, 0, 0,
            0, 0, 0)

        checkForExistingValues()

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
        val val2 : String = edit2.text.toString()
        val val3 : String = edit3.text.toString()
        val val4 : String = edit4.text.toString()
        val val5 : String = edit5.text.toString()

        if(val1 != "" && val2 != "" && val3 != ""
            && val4 != "" && val5 != ""){
            model.setInitialBal(val1.toInt())
            /*
            model.setVal2(val2.toInt())
            model.setVal3(val3.toInt())
            model.setVal4(val4.toInt())
            model.setVal5(val5.toInt())
            */

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
        intent.putExtra("val1", model.getInitialBal())
        /*
        intent.putExtra("val2", model.getVal2())
        intent.putExtra("val3", model.getVal3())
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
        val val1 = intent.getIntExtra("val1", -1)
        val val2 = intent.getIntExtra("val2", -1)
        val val3 = intent.getIntExtra("val3", -1)
        val val4 = intent.getIntExtra("val4", -1)
        val val5 = intent.getIntExtra("val5", -1)

        //cheaty way to check all arent -1
        if(val1 + val2 + val3 + val4 + val5 != -5){
            model.setInitialBal(val1)
            /*
            model.setVal2(val2)
            model.setVal3(val3)
            model.setVal4(val4)
            model.setVal5(val5)
            */

            setViews()
        }
    }

    private fun setViews(){
        var x = findViewById<EditText>(R.id.edit1)
        x.setText(model.getInitialBal().toString())
        /*
        x = findViewById(R.id.edit2)
        x.setText(model.getVal2().toString())
        x = findViewById(R.id.edit3)
        x.setText(model.getVal3().toString())
        x = findViewById(R.id.edit4)
        x.setText(model.getVal4().toString())
        x = findViewById(R.id.edit5)
        x.setText(model.getVal5().toString())
        */
    }
}