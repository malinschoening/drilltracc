package com.example.drilltracc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_settings.*


class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        var workoutGoal = findViewById<EditText>(R.id.goalNumber)

        workoutGoal.setText(DataManager.weeklyGoal.toString())

        var cheatDay = findViewById<TextView>(R.id.weekday)

        var mainGoalRange = findViewById<EditText>(R.id.mainGoalRange)

        mainGoalRange.setText(DataManager.mainGoalRange.toString())

        var daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "NONE")

        //display the right day
        var a = 7
        while(DataManager.cheatDay != daysOfWeek[a]){
            a--
        }
        cheatDay.text = DataManager.cheatDay

        var left = findViewById<ImageButton>(R.id.leftDay)
        var right = findViewById<ImageButton>(R.id.rightDay)

        //change the days
        left.setOnClickListener{
            if (a > 0){
                a = a - 1
            }else {
                a = 7
            }

            cheatDay.text = daysOfWeek[a]
        }
        right.setOnClickListener{
            if (a < 7){
                a = a + 1
            }else {
                a = 0
            }
            cheatDay.text = daysOfWeek[a]
        }


        var saveSettings = findViewById<Button>(R.id.saveSettingsButton)
        var settingsSaved = findViewById<TextView>(R.id.settingsSavedTitle)

        saveSettings.setOnClickListener {
            settingsSaved.alpha = 1F
            DataManager.cheatDay = cheatDay.text.toString()
            DataManager.dailyGoal = (workoutGoal.text.toString().toDouble() / 6).toInt()
            DataManager.weeklyGoal = workoutGoal.text.toString().toInt()
            DataManager.mainGoal = workoutGoal.text.toString().toInt() * mainGoalRange.text.toString().toInt() * 4
            DataManager.mainGoalRange = mainGoalRange.text.toString().toInt()
            backToMain()
        }

    }

    fun backToMain(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}
