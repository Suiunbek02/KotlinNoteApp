package com.example.projectkotlin1.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NoteApp")
data class NoteModel(
    @ColumnInfo
val title: String,

    @ColumnInfo
val description: String,

    @ColumnInfo
val date: String,

    @ColumnInfo
val time: String,
val color:String
) {
@PrimaryKey(autoGenerate = true)
var id:Int = 0



}
