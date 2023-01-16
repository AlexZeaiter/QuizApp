package com.example.quizapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizapp.databinding.FragmentAnalysisBinding
import com.example.quizapp.databinding.FragmentHomeBinding

class AnalysisFragment : Fragment() {

    private lateinit var binding: FragmentAnalysisBinding
    private lateinit var adapter: MyAdapter
    private lateinit var answersViewModel: AnswersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAnalysisBinding.inflate(inflater, container, false)
        answersViewModel = ViewModelProvider(requireActivity()).get(AnswersViewModel::class.java)
        var questions = answersViewModel!!.getQuestionsList()

        // Set the Layout Manager
        binding.recyclerView1.layoutManager = LinearLayoutManager(activity)
        // Create an object for the MyAdapter
        adapter = MyAdapter(questions)
        // Set adapter to your RecyclerView
        binding.recyclerView1.adapter = adapter

        return binding.root
    }
}