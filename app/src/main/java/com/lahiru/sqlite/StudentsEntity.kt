package com.lahiru.sqlite

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students-table")
data class StudentsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "email-id")
    val email : String = "",
    val name: String = "",
    val age : Int = 0,
    val phone: String = ""
)
