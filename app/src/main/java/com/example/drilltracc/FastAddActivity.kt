package com.example.drilltracc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView



const val POSITION_NOT_SET = -1
const val WORKOUT_POSITION_KEY = "WORKOUT_POSITION"
class FastAddActivity : AppCompatActivity() {

    lateinit var editStrength : EditText
    lateinit var editCardio : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fast_add)

        editStrength = findViewById<EditText>(R.id.editStrength)
        editCardio = findViewById<EditText>(R.id.editCardio)

        val saveButton = findViewById<Button>(R.id.saveButton)

        var position = intent.getIntExtra(WORKOUT_POSITION_KEY, POSITION_NOT_SET)

        if (position != POSITION_NOT_SET){
            //edit already existing workout
            displayDate(position)
            saveButton.setOnClickListener {
                editWorkout(position)
            }
        }else{
            //add new workout
            saveButton.setOnClickListener {
                addWorkout()
            }
        }

    }
        fun displayDate(pos: Int){
            val workout = DataManager.workOuts[pos]
            editCardio.setText(workout.cardio)
            editStrength.setText(workout.strength)
        }
        fun editWorkout(pos: Int){
            DataManager.workOuts[pos].strength = editStrength.text.toString()
            DataManager.workOuts[pos].cardio = editCardio.text.toString()
            finish()
        }



        fun addWorkout() {
            var strength = editStrength.text.toString()
            var cardio = editCardio.text.toString()
            //change this to the current date
            var currentDate = "2020.09.02"
            val workOut = Date(name = currentDate)
            if(strength == ""){
                workOut.strength = "none"
            }else{
                workOut.strength = strength
            }
            if(cardio == ""){
                workOut.cardio = "none"
            }else{
                workOut.cardio = cardio
            }
            if(cardio == "" && strength == ""){
                backToMain()
            }
            else {
                DataManager.workOuts.add(workOut)
                backToMain()
            }
        }

    fun backToMain(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}