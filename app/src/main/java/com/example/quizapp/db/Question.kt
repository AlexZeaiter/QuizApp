package com.example.quizapp.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Entity
data class Question(val question : String,
                    val answerOne : String,
                    val answerTwo : String,
                    val answerThree : String,
                    val correctAnswer :String,
                    var answer : String
                    ): Serializable
{
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}

@Parcelize
class Questions: ArrayList<Question>(), Parcelable