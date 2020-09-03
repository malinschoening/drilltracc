package com.example.drilltracc

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var totalGoalTitle = findViewById<TextView>(R.id.totalGoalTitle)
        var weeklyGoalTitle = findViewById<TextView>(R.id.weeklyGoalTitle)
        var dailyGoalTitle = findViewById<TextView>(R.id.dailyGoalTitle)

        totalGoalTitle.text = "TOTAL GOAL (${DataManager.mainGoal})"
        weeklyGoalTitle.text = "WEEKLY GOAL(${DataManager.weeklyGoal})"
        dailyGoalTitle.text = "DAILY GOAL(${DataManager.dailyGoal})"


            val cheatDayTitle = findViewById<TextView>(R.id.cheatDayTitle)
            cheatDayTitle.text = DataManager.cheatDay

            val mainPercentage = findViewById<TextView>(R.id.percentageMainGoal)

        var mainPercentageNumber = ((DataManager.workOuts.size / DataManager.mainGoal.toDouble()) * 100).toInt()
        var weeklyPercentageNumber = ((DataManager.workOuts.size / DataManager.weeklyGoal.toDouble()) * 100).toInt()
        var dailyPercentageNumber = ((DataManager.workOuts.size / DataManager.dailyGoal.toDouble()) * 100).toInt()

        //display the percentage, if it is 100%, display DONE
        if (mainPercentageNumber < 100) {
                mainPercentage.text =
                    mainPercentageNumber.toString() + "%"
            }else {
            mainPercentage.text = "DONE"
        }
            val mainGoalLine = findViewById<TextView>(R.id.mainGoalLine)

            val weeklyPercentage = findViewById<TextView>(R.id.percentageWeeklyGoal)


            if(weeklyPercentageNumber < 100){
                weeklyPercentage.text =
                    weeklyPercentageNumber.toString() + "%"
            } else {
                weeklyPercentage.text = "DONE"
            }
            val weeklyGoalLine = findViewById<TextView>(R.id.weeklyGoalLine)

            val dailyPercentage = findViewById<TextView>(R.id.percentageDailyGoal)

        if(dailyPercentageNumber < 100) {
            dailyPercentage.text =
                dailyPercentageNumber.toString() + "%"
        }else {
            dailyPercentage.text = "DONE"
        }
            val dailyGoalLine = findViewById<TextView>(R.id.dailyGoalLine)

        //display the lines under the title
            mainGoalLine.text = percentageLine(mainPercentageNumber)

            weeklyGoalLine.text = percentageLine(weeklyPercentageNumber)

            dailyGoalLine.text = percentageLine(dailyPercentageNumber)


            val historyButton = findViewById<ImageButton>(R.id.history)

            historyButton.findViewById<ImageButton>(R.id.history)
            historyButton.setOnClickListener {
                startAddAndCreateWorkOutActivity()
            }

            val settingsButton = findViewById<ImageButton>(R.id.settings)

            settingsButton.setOnClickListener {
                startSettingsActivity()
            }

            val fab = findViewById<View>(R.id.floatingActionButton3)

            fab.setOnClickListener { view ->
                val intent = Intent(this, FastAddActivity::class.java)
                startActivity(intent)
            }

        }

    fun startAddAndCreateWorkOutActivity(){
        val intent = Intent(this, AddAndCreateWorkOutActivity::class.java)
        startActivity(intent)
    }

    fun startSettingsActivity(){
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

    //function to display the line under the percentage
    fun percentageLine(quantity : Int): String {
        when(quantity) {
            0 -> return " "

            in 1..5 -> return "_"

            in 6..10 -> return "__"

            in 11..15 -> return "___"

            in 16..20 -> return  "____"

            in 21..25 -> return "_____"

            in 26..30 -> return "______"

            in 31..35 -> return "_______"

            in 36..40 -> return "________"

            in 41..45 -> return "_________"

            in 46..50 -> return "__________"

            in 51..55 -> return "___________"

            in 56..60 -> return "____________"

            in 61..65 -> return "_____________"

            in 66..70 -> return "______________"

            in 71..75 -> return "_______________"

            in 76..80 -> return "________________"

            in 81..85 -> return "_________________"

            in 86..90 -> return "__________________"

            in 91..95 -> return "___________________"

            in 96..99 -> return "____________________"

            else -> return "CONGRATULATIONS"
        }
        }

    }
