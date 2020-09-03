package com.example.drilltracc

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class WorkOutsRecyclerAdapter(private val context : Context , public val dates : List<Date>) :
    RecyclerView.Adapter<WorkOutsRecyclerAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = dates.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val date= dates[dates.size - 1 - position]
        holder.textViewDate.text = date.name
        holder.textViewStrength.text = date.strength
        holder.textViewCardio.text = date.cardio
        holder.listPosition = dates.size - 1 - position
    }

    fun removeWorkout(position : Int){
        DataManager.workOuts.removeAt(position)
        notifyDataSetChanged()
    }

    fun backToMain(){
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val textViewDate = itemView.findViewById<TextView>(R.id.date)
        val textViewStrength = itemView.findViewById<TextView>(R.id.strengthData)
        val textViewCardio = itemView.findViewById<TextView>(R.id.cardioData)
        val deleteButton = itemView.findViewById<Button>(R.id.deleteButton)
        var listPosition = 0

        init{

            itemView.setOnClickListener{
                val intent = Intent(context, FastAddActivity::class.java)
                intent.putExtra(WORKOUT_POSITION_KEY, listPosition)
                context.startActivity(intent)

            }
            deleteButton.setOnClickListener {
                Snackbar.make(it, "WORKOUT REMOVED", Snackbar.LENGTH_LONG)
                removeWorkout(listPosition)
                backToMain()
            }
        }




    }

}