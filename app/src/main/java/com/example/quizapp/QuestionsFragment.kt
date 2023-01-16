package com.example.quizapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.quizapp.databinding.FragmentQuestionsBinding
import com.example.quizapp.db.Question
import com.example.quizapp.db.QuestionDatabase
import com.example.quizapp.db.Questions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class QuestionsFragment : BaseFragment() {

    private lateinit var binding: FragmentQuestionsBinding
    private var counter: Int = 0
    var score: Int = 0
    private var questions: List<Question> = listOf()

    private lateinit var answersViewModel: AnswersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuestionsBinding.inflate(inflater, container, false)
        answersViewModel = ViewModelProvider(requireActivity()).get(AnswersViewModel::class.java)

        launch {
            context?.let {
                questions = QuestionDatabase(it).getQuestionDao().getAllQuestions()
                answersViewModel!!.addQuestionsList(questions)
            }
            if (counter == 0 && questions.isNotEmpty()) {
                binding.question.text = questions[counter].question
                binding.answer1.text = questions[counter].answerOne
                binding.answer2.text = questions[counter].answerTwo
                binding.answer3.text = questions[counter].answerThree
            }
            binding.apply {
                next.setOnClickListener {
                    val selectedId: Int = rg.checkedRadioButtonId
                    if (selectedId != -1) {
                        var radioButton = view?.findViewById(selectedId) as RadioButton
                        answersViewModel!!.updateAnswer(counter, (radioButton.text.toString()))
                        if (radioButton.text.toString() == questions[counter].correctAnswer) {
                            score++
                        }
                        rg.clearCheck()
                        if (counter + 1 == questions.size) {
                            counter = 0
                            val direction =
                                QuestionsFragmentDirections.actionQuestionsFragmentToResultsFragment(
                                    score
                                )
                            findNavController().navigate(direction)
                        } else {
                            counter++
                            question.text = questions[counter].question
                            answer1.text = questions[counter].answerOne
                            answer2.text = questions[counter].answerTwo
                            answer3.text = questions[counter].answerThree
                        }
                    } else {
                        Toast.makeText(requireActivity(), "Please Select An Answer", Toast.LENGTH_LONG).show()
                    }
                }
                binding.home.setOnClickListener{
                    answersViewModel!!.deleteQuestionsList()

                    val direction =
                        QuestionsFragmentDirections.actionQuestionsFragmentToHomeFragment()
                    findNavController().navigate(direction)
                }
            }
        }

        return binding.root
    }
}

