package com.example.drilltracc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

lateinit var recyclerView: RecyclerView
class AddAndCreateWorkOutActivity : AppCompatActivity() {

    val dates = DataManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_and_create_work_out)

        recyclerView = findViewById<RecyclerView>(R.id.workoutList)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = WorkOutsRecyclerAdapter(this, dates.workOuts)

        recyclerView.adapter = adapter

        val fab = findViewById<View>(R.id.floatingActionButton1)

        fab.setOnClickListener{ view ->
            val intent = Intent(this, FastAddActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        recyclerView.adapter?.notifyDataSetChanged()
    }
}
