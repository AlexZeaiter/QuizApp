package com.example.quizapp.db
import android.os.Parcel
import android.os.Parcelable
import androidx.room.*
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface QuestionDao{

    @Insert
    suspend fun addQuestion(question: Question)
    @Query("SELECT * FROM QUESTION ORDER BY id ASC")
    suspend fun getAllQuestions():List<Question>
    @Update
    suspend fun updateQuestion(question: Question)
    @Delete
    suspend fun deleteQuestion(question: Question)
    @Query("DELETE FROM QUESTION")
    suspend fun deleteTable()
}