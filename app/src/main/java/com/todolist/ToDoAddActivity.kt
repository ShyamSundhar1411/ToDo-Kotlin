package com.todolist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_to_do_add.*

class ToDoAddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_add)
        saveButton.setOnClickListener {
            var title : String = ""
            if(importantCheckBox.isChecked){
                title = "❗ "+titleTextBox.text.toString()
            }
            else{
                title = titleTextBox.text.toString()
            }
            var prefs = getSharedPreferences(getString(R.string.SHARED_PREFS), Context.MODE_PRIVATE)
            var todos = prefs.getStringSet(getString(R.string.TODO_STRINGS), setOf())?.toMutableSet()
            todos?.add(title)
            prefs.edit().putStringSet(getString(R.string.TODO_STRINGS),todos).apply()
            finish()

        }
    }
}