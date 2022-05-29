package com.example.kotlinapplication.data.repository

import com.example.kotlinapplication.data.entity.ToDoEntity

class TestToDoRepository : ToDoRepository {

    private val toDoList: MutableList<ToDoEntity> = mutableListOf()

    override suspend fun getToDoList(): List<ToDoEntity> {
        return toDoList
    }

    override suspend fun insertToDoList(toDoList: List<ToDoEntity>) {
        this.toDoList.addAll(toDoList)
    }

    override suspend fun insertToDoItem(toDoEntity: ToDoEntity): Long {
        this.toDoList.add(toDoEntity)
        return toDoList.indexOf(toDoEntity).toLong()
    }

    override suspend fun updateToDoItem(toDoEntity: ToDoEntity) {
        val foundToDoEntity = toDoList.find { it.id == toDoEntity.id }
//        return if (foundToDoEntity == null) {
//            false
//        } else {
//            this.toDoList[toDoList.indexOf(foundToDoEntity)] = toDoEntity
//            true
//        }
    }

    override suspend fun getToDoItem(itemId: Long): ToDoEntity? {
        return toDoList.find { it.id == itemId }
    }

    override suspend fun deleteAll() {
        this.toDoList.clear()
    }

    override suspend fun deleteToDoItem(itemId: Long) {
        val foundToDoEntity = toDoList.find { it.id == itemId }
//        return if(foundToDoEntity == null) {
//            false
//        } else {
//            this.toDoList.removeAt(toDoList.indexOf(foundToDoEntity))
//            true
//        }
    }
}