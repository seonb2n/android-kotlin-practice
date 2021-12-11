package com.example.kotlinapplication.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlinapplication.model.History

@Dao
interface HistoryDao{

    @Query("SELECT * FROM history")
    fun getAll(): List<History>

    @Insert
    fun insertHistory(history: History)

    @Query("DELETE FROM history")
    fun deleteAll()

    /**
    @Delete
    fun delete(history: History)

    @Query("SELECT * FROM history WHERE result LIKE :result")
    fun findByResult(result: String): List<History>

    **/

}