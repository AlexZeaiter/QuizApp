package com.example.quizapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizapp.db.Question

class AnswersViewModel: ViewModel() {
    var questionsList = MutableLiveData<List<Question>>()
    init {
        questionsList.value = listOf()
    }
   fun addQuestion(question : Question){
       questionsList.value?.plus(question)
    }
    fun updateAnswer(counter: Int, answer: String)
    {
        questionsList.value?.get(counter)!!.answer  = answer
    }
    fun addQuestionsList(questions: List<Question>){
        questionsList.value = questionsList.value?.plus(questions)
    }
    fun deleteQuestionsList(){
        questionsList.value = listOf()
    }
    fun getQuestion (counter: Int) : Question {
        return questionsList.value?.get(counter)!!
    }
    fun getQuestionsList() : List<Question>{
        return questionsList.value!!
    }
}