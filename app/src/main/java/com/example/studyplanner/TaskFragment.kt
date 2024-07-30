package com.example.studyplanner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

class TaskFragment : Fragment() {
    companion object{
        val tasks = mutableListOf<TasksSingleton>()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_study, container, false)

        val editTextTaskTitle: EditText = view.findViewById(R.id.edit_text_task_title)
        val radioGroupPriority: RadioGroup = view.findViewById(R.id.radio_group_priority)
        val buttonSaveTask: Button = view.findViewById(R.id.button_save_task)

        buttonSaveTask.setOnClickListener {
            val taskTitle = editTextTaskTitle.text.toString()
            val selectedPriorityId = radioGroupPriority.checkedRadioButtonId
            val taskPriority = when (selectedPriorityId) {
                R.id.radio_high -> "Study"
                R.id.radio_medium -> "Leisure"
                R.id.radio_low -> "Others"
                else -> "None"
            }

            val task = "$taskTitle - Priority: $taskPriority"
            tasks.add(TasksSingleton(taskTitle,taskPriority))

            Toast.makeText(context, "Task Saved: $task", Toast.LENGTH_SHORT).show()
            editTextTaskTitle.text.clear()
            radioGroupPriority.clearCheck()
        }

        return view
    }
}







