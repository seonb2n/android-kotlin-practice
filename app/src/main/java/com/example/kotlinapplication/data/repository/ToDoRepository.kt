package com.example.kotlinapplication.data.repository

import com.example.kotlinapplication.data.entity.ToDoEntity

/**
 * 1. insertToDoList
 * 2. getToDoList
 */

interface ToDoRepository {

    suspend fun getToDoList(): List<ToDoEntity>

    suspend fun insertToDoList(toDoList: List<ToDoEntity>)

}