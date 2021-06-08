package com.todolist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_to_do_detail.*

class ToDoDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_detail)
        val todo = intent.extras?.getString("title")
        todoTitle.text = todo
        completeButton.setOnClickListener {
            var prefs = getSharedPreferences(getString(R.string.SHARED_PREFS), Context.MODE_PRIVATE)
            val todos = prefs.getStringSet(getString(R.string.TODO_STRINGS), setOf())?.toMutableSet()
            todos?.remove(todo)
            prefs.edit().putStringSet(getString(R.string.TODO_STRINGS),todos).apply()
            finish()

        }

    }
}