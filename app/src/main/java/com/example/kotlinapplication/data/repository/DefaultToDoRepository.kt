package com.example.kotlinapplication.data.repository

import com.example.kotlinapplication.data.entity.ToDoEntity
import com.example.kotlinapplication.data.local.db.dao.ToDoDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class DefaultToDoRepository(
    private val toDoDao: ToDoDao,
    private val ioDispatcher: CoroutineDispatcher
): ToDoRepository {
    override suspend fun getToDoList(): List<ToDoEntity> = withContext(ioDispatcher) {
        toDoDao.getAll()
    }


    override suspend fun getToDoItem(itemId: Long): ToDoEntity?  = withContext(ioDispatcher){
        toDoDao.getById(itemId)
    }

    override suspend fun insertToDoList(toDoList: List<ToDoEntity>) = withContext(ioDispatcher){
        toDoDao.insert(toDoList)
    }

    override suspend fun insertTodoItem(toDoItem: ToDoEntity): Long  = withContext(ioDispatcher){
        toDoDao.insert(toDoItem)
    }

    override suspend fun updateToDoItem(toDoEntity: ToDoEntity): Boolean  = withContext(ioDispatcher){
       updateToDoItem(toDoEntity)
    }


    override suspend fun deleteAll()  = withContext(ioDispatcher){
        toDoDao.deleteAll()
    }

    override suspend fun deleteToDoItem(itemId: Long): Boolean = withContext(ioDispatcher) {
        toDoDao.delete(itemId)
    }
}