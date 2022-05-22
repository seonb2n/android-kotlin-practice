package com.example.kotlinapplication.data.repository

import com.example.kotlinapplication.data.entity.ToDoEntity

class DefaultToDoRepository: ToDoRepository {
    override suspend fun getToDoList(): List<ToDoEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun insertToDoList(toDoList: List<ToDoEntity>) {
        TODO("Not yet implemented")
    }

    override suspend fun updateToDoItem(toDoEntity: ToDoEntity): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getToDoItem(itemId: Long): ToDoEntity? {
        TODO("Not yet implemented")
    }
}