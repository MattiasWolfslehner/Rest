package com.example.rest.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rest.ui.components.TodoItem
import com.example.rest.viewmodel.TodoViewModel

@Composable
fun TodoScreen(
    viewModel: TodoViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    modifier: Modifier
) {
    val todos = viewModel.todos.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(todos.value) { todo ->
            TodoItem(todo)
        }
    }
}