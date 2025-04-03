package com.example.todolist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup RecyclerView and adapter with an empty list; LiveData will update it.
        val rvTodoItems = findViewById<RecyclerView>(R.id.rvTodoItems)
        todoAdapter = TodoAdapter(mutableListOf())
        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        // Observe the LiveData from the Room database.
        DatabaseApplication.todoDatabase.getTodoDao().getAllTodo().observe(this, Observer { todos ->
            // Update the adapter's data.
            todoAdapter.setTodos(todos.toMutableList())
        })

        // Add new todo
        val btAddTodo = findViewById<Button>(R.id.btaddTodo)
        btAddTodo.setOnClickListener {
            val etTodo = findViewById<EditText>(R.id.etTodoTitle)
            val todoTitle = etTodo.text.toString()
            if (todoTitle.isNotEmpty()) {
                val todo = Todo(0, todoTitle) // Assuming '0' is auto-generated.
                // Insert the new todo into the database.
                DatabaseApplication.todoDatabase.getTodoDao().addTodo(todo)
                etTodo.text.clear()
            }
        }

        // Delete completed todos
        val btDelete = findViewById<Button>(R.id.btdeleteTodo)
        btDelete.setOnClickListener {
            // Delete todos where isCompleted is true.
            DatabaseApplication.todoDatabase.getTodoDao().deleteTodo()
        }
    }
}
