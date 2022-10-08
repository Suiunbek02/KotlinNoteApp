package com.example.projectkotlin1.data.locale.room.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.projectkotlin1.model.NoteModel

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(noteModel: NoteModel)

    @Delete
    fun delete(noteModel: NoteModel)

    @Query("SELECT * FROM NoteApp")
    fun getALLModels(): LiveData<List<NoteModel>>

}