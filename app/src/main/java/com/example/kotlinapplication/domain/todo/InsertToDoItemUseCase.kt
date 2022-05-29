package com.example.kotlinapplication.domain.todo

import com.example.kotlinapplication.data.entity.ToDoEntity
import com.example.kotlinapplication.data.repository.ToDoRepository
import com.example.kotlinapplication.domain.UseCase

class InsertToDoItemUseCase(
    private val toDoRepository: ToDoRepository
): UseCase {

    suspend operator fun invoke(toDoItem: ToDoEntity): Long {
        return toDoRepository.insertToDoItem(toDoItem)
    }

}