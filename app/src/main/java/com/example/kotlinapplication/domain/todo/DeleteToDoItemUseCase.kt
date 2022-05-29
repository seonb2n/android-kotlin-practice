package com.example.kotlinapplication.domain.todo

import com.example.kotlinapplication.data.entity.ToDoEntity
import com.example.kotlinapplication.data.repository.ToDoRepository
import com.example.kotlinapplication.domain.UseCase

internal class DeleteToDoItemUseCase(
    private val toDoRepository: ToDoRepository
): UseCase {

    suspend operator fun invoke(id: Long) {
        return toDoRepository.deleteToDoItem(id)
    }

}