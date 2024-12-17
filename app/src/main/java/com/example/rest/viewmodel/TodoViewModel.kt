package com.example.rest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rest.data.model.Todo
import com.example.rest.data.remote.RetrofitInstance
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TodoViewModel : ViewModel() {
    private val _todos = MutableStateFlow<List<Todo>>(listOf(
        Todo(1,1,"Retrofit lernen",false),
        Todo(1,2,"Video Rawcut",false),
        Todo(1,3,"Game Design",false),
        Todo(1,4,"Mathe AA",false),
        Todo(1,5,"Motion Design Video",false),
        Todo(1,6,"ITP Projekt",false),
        Todo(1,7,"ITP AA",false),
        Todo(1,8,"DA schreiben",false),
        Todo(1,9,"Audio",false),
    ))
    val todos: StateFlow<List<Todo>> get() = _todos

    init {
        fetchTodos()
    }

    private fun fetchTodos() {
        viewModelScope.launch {
            delay(3000)
            try {
                val response = RetrofitInstance.api.getTodos()
                _todos.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}