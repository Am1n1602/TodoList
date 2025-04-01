package com.example.todolist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rvTodoItems = findViewById<RecyclerView>(R.id.rvTodoItems)
        todoAdapter = TodoAdapter(mutableListOf())

        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        val btAddTodo = findViewById<Button>(R.id.btaddTodo)
        btAddTodo.setOnClickListener {
            val etTodo = findViewById<EditText>(R.id.etTodoTitle)
            val todoTitle = etTodo.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etTodo.text.clear()
            }
        }
        val btDelete = findViewById<Button>(R.id.btdeleteTodo)
        btDelete.setOnClickListener {
            todoAdapter.deleteTodo()
        }
    }
}
