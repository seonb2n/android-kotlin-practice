package com.example.kotlinapplication.domain.todo

import com.example.kotlinapplication.data.entity.ToDoEntity
import com.example.kotlinapplication.data.repository.ToDoRepository
import com.example.kotlinapplication.domain.UseCase

internal class GetToDoListUseCase(
    private val toDoRepository: ToDoRepository
): UseCase {
    suspend operator fun invoke():List<ToDoEntity> {
        return toDoRepository.getToDoList()
    }
}