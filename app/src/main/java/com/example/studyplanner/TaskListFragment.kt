package com.example.studyplanner
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TaskListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: TaskListAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_task_list, container, false)

        viewManager = LinearLayoutManager(context)
        viewAdapter = TaskListAdapter(TaskFragment.tasks)

        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_tasks).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        return view
    }
}