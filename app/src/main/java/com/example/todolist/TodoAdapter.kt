package com.example.todolist

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(
    private val todos: MutableList<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.items_todo,
                parent,
                false
            )
        )
    }

    fun addTodo(todo: Todo) {
        todos.add(todo)
        notifyItemInserted(todos.size-1)
    }

    fun deleteTodo() {
        todos.removeAll { todo ->
            todo.isCompleted
        }
        notifyDataSetChanged()
    }

    private fun switchStrikeThrough(tvTodoTitle: TextView, isCompleted: Boolean) {
        if (isCompleted) {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentTodo= todos[position]
        holder.itemView.apply {
            val tvTodoTitle = findViewById<TextView>(R.id.tvTodoTitle)
            val cbDone = findViewById<CheckBox>(R.id.cbDone)
            tvTodoTitle.text = currentTodo.title
            cbDone.isChecked = currentTodo.isCompleted
            switchStrikeThrough(tvTodoTitle, currentTodo.isCompleted)
            cbDone.setOnCheckedChangeListener { _, isCompleted ->
                switchStrikeThrough(tvTodoTitle, isCompleted)
                currentTodo.isCompleted = !currentTodo.isCompleted
            }
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}