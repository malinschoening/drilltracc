package com.example.drilltracc
object DataManager {

    val workOuts = mutableListOf<Date>()
    var cheatDay = "Saturday"
    var mainGoal = 3 * 3 * 4
    var weeklyGoal = 3
    var dailyGoal = 1
    var mainGoalRange = 3

    init {
        createMockData()
    }

    fun createMockData(){
        var work = Date("2020.08.28")
        work.strength = "arms, back"
        workOuts.add(work)
        var workout = Date("2020.08.31")
        workout.cardio = "HIIT, walk"
        workOuts.add(workout)
    }
}