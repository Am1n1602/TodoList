package com.example.todolist

import android.app.Application
import androidx.room.Room
import com.example.todolist.database.TodoDatabase

class DatabaseApplication : Application() {
    companion object {
        lateinit var todoDatabase: TodoDatabase
    }

    override fun onCreate() {
        super.onCreate()
        todoDatabase = Room.databaseBuilder(
            applicationContext,
            TodoDatabase::class.java,
            TodoDatabase.NAME
        )
            .allowMainThreadQueries() // Only for testing; use background threads in production.
            .build()
    }
}
