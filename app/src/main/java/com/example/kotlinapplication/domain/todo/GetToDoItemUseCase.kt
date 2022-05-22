package com.example.kotlinapplication.domain.todo

import com.example.kotlinapplication.data.entity.ToDoEntity
import com.example.kotlinapplication.data.repository.ToDoRepository
import com.example.kotlinapplication.domain.UseCase

internal class GetToDoItemUseCase(
    private val toDoRepository: ToDoRepository
): UseCase {
    suspend operator fun invoke(itemId: Long): ToDoEntity? {
        return toDoRepository.getToDoItem(itemId)
    }
}