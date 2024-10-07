package com.example.tareatracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tareatracker.R

class ButtonsFragment : Fragment() {

    private lateinit var taskAdapter: TaskAdapter
    private lateinit var taskList: MutableList<Task>
    private lateinit var recyclerView: RecyclerView
    private lateinit var taskNameInput: EditText
    private lateinit var taskDescriptionInput: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_buttons, container, false)


        taskList = mutableListOf()


        recyclerView = view.findViewById(R.id.recycler_view)
        taskAdapter = TaskAdapter(taskList)
        recyclerView.adapter = taskAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)


        taskNameInput = view.findViewById(R.id.task_name)
        taskDescriptionInput = view.findViewById(R.id.task_description)

        val saveButton: Button = view.findViewById(R.id.btn_save)
        saveButton.setOnClickListener {
            saveTask()
        }

        return view
    }


    private fun saveTask() {
        val taskName = taskNameInput.text.toString()
        val taskDescription = taskDescriptionInput.text.toString()


        if (taskName.isNotEmpty() && taskDescription.isNotEmpty()) {

            val newTask = Task(taskName, taskDescription)
            taskList.add(newTask)


            taskAdapter.notifyItemInserted(taskList.size - 1)


            taskNameInput.text.clear()
            taskDescriptionInput.text.clear()
        }
    }
}