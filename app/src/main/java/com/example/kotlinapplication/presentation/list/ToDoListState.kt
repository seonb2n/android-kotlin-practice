package com.example.kotlinapplication.presentation.list

import com.example.kotlinapplication.data.entity.ToDoEntity

sealed class ToDoListState {

    object UnInitialized: ToDoListState()

    object Loading: ToDoListState()

    data class Success (
        val ToDoList: List<ToDoEntity>
        ): ToDoListState()

    object Error: ToDoListState()
}