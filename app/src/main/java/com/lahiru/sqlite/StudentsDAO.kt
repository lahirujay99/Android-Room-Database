package com.lahiru.sqlite

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentsDAO {
    @Insert
    suspend fun Insert(studentsEntity: StudentsEntity)

    @Update
    suspend fun Update(studentsEntity: StudentsEntity)

    @Delete
    suspend fun Delete(studentsEntity: StudentsEntity)

    @Query("SElECT * FROM `students-table`")
    fun fetchAllStudents():Flow<List<StudentsEntity>>

    @Query("SELECT * FROM `students-table` WHERE id=:id")
    fun fetchStudentById(id:Int):Flow<StudentsEntity>
}