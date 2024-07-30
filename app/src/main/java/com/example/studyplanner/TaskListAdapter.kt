package com.example.studyplanner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskListAdapter(private val tasks: MutableList<TasksSingleton>) :
    RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {

    class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewTask: TextView = view.findViewById(R.id.text_view_task)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_list_item, parent, false) as View
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.textViewTask.text = "Plan type name "+task.taskTitle +" Plan Type "+ task.taskPriority
    }

    override fun getItemCount() = tasks.size
}