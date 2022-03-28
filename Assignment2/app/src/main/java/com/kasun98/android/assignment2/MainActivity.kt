package com.kasun98.android.assignment2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

        val saveButton: Button = findViewById(R.id.button)


        saveButton.setOnClickListener{
            saveData()
        }

    }


    private fun saveData(){
        val enteredText: TextView = findViewById(R.id.enteredText)
        val changingText: TextView = findViewById(R.id.textView11)
        val switch: Switch = findViewById(R.id.switch1)
        val state: TextView = findViewById(R.id.textView12)


        val textEntered = enteredText.text
        changingText.text = "stored Text: $textEntered"
        val booleanState = switch.isChecked
        state.text = "State is : $booleanState"




        val sharedPreferences = getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.apply {
            putString("STRING_KEY", textEntered.toString())
            putBoolean("BOOLEAN_KEY",switch.isChecked)

        }.apply()


    }




    private fun loadData(){

        val changingText: TextView = findViewById(R.id.textView11)
        val switch: Switch = findViewById(R.id.switch1)
        val booleanState: TextView = findViewById(R.id.textView12)

        val sharedPreferences = getSharedPreferences("sharedPreferences" , Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("STRING_KEY",null)
        val savedBoolean = sharedPreferences.getBoolean("BOOLEAN_KEY",false)

        changingText.text = "stored Text: $savedString"
        switch.isChecked = savedBoolean
        booleanState.text = "State is : $savedBoolean"


    }

}