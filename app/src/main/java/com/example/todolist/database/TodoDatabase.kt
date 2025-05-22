package com.example.todolist.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolist.Todo


@Database(entities = [Todo::class], version = 1)
abstract class TodoDatabase: RoomDatabase() {
    companion object {
        const val NAME = "database_Todo"
    }
    abstract fun getTodoDao() : TodoDao
}