package com.example.quicklistapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Context
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    
    private lateinit var etTaskInput: EditText
    private lateinit var btnAdd: Button
    private lateinit var rvTasks: RecyclerView

    private lateinit var taskAdapter: TaskAdapter
    private var taskList: MutableList<String> = mutableListOf()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // 1. Inicializar Componentes
        etTaskInput = findViewById(R.id.etTaskInput)
        btnAdd = findViewById(R.id.btnAdd)
        rvTasks = findViewById(R.id.rvTasks)

        // 2. Carregar dados salvos
        loadTasks()

        // 3. Configurar RecyclerView
        taskAdapter = TaskAdapter(taskList) { position ->
            removeTask(position)
        }
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = taskAdapter

        // 4. Ação do Botão Adicionar
        btnAdd.setOnClickListener {
            val taskText = etTaskInput.text.toString().trim()
            if (isValidTask(taskText)) {
                addTask(taskText)
                etTaskInput.text.clear()
            } else {
                Toast.makeText(this, "A tarefa não pode estar vazia!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidTask(text: String): Boolean {
        return text.isNotEmpty()
    }

    private fun addTask(task: String) {
        taskList.add(task)
        taskAdapter.notifyItemInserted(taskList.size - 1)
        saveTasks() // Persistir
    }

    private fun removeTask(position: Int) {
        taskList.removeAt(position)
        taskAdapter.notifyItemRemoved(position)
        taskAdapter.notifyItemRangeChanged(position, taskList.size)
        saveTasks() // Atualizar persistência
    }


    private fun saveTasks() {
        val sharedPreferences = getSharedPreferences("QuickListApp", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(taskList)
        editor.putString("task_list", json)
        editor.apply()
    }

    private fun loadTasks() {
        val sharedPreferences = getSharedPreferences("QuickListApp", Context.MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("task_list", null)

        val type = object : TypeToken<MutableList<String>>() {}.type

        if (json != null) {
            val savedList: MutableList<String> = gson.fromJson(json, type)
            taskList.addAll(savedList)
        }
    }
}