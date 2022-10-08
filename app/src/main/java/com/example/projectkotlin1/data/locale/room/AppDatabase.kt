package com.example.projectkotlin1.data.locale.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projectkotlin1.data.locale.room.daos.NoteDao
import com.example.projectkotlin1.model.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class AppDatabase: RoomDatabase () {
abstract fun getNoteDao():NoteDao
}