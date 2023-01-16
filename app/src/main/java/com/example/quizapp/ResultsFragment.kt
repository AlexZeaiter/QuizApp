package com.example.quizapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.quizapp.databinding.FragmentResultsBinding
import com.example.quizapp.db.Question
import kotlinx.android.synthetic.main.fragment_results.*


class ResultsFragment : Fragment() {
    private lateinit var binding: FragmentResultsBinding
    val args :ResultsFragmentArgs by navArgs()
    private lateinit var answersViewModel: AnswersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultsBinding.inflate(inflater, container, false)
        var score = args.score
        //var questions = args.questions
        binding.score.text = "Your Score is: ${score.toString()}/15"
        binding.wrong.text = "Wrong Answers is: ${15 - score}"
        binding.correct.text = "Correct Answers{Score}: $score"

        binding.analysis.setOnClickListener{
            val direction =
                ResultsFragmentDirections.actionResultsFragmentToAnalysisFragment()
            findNavController().navigate(direction)
        }
        binding.repeat.setOnClickListener{
            answersViewModel = ViewModelProvider(requireActivity()).get(AnswersViewModel::class.java)
            answersViewModel!!.deleteQuestionsList()

            val direction =
                ResultsFragmentDirections.actionResultsFragmentToQuestionsFragment()
            findNavController().navigate(direction)
        }
        return binding.root
    }
}