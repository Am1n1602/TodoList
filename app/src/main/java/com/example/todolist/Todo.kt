package com.example.todolist

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Todo (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    var isCompleted: Boolean = false
)