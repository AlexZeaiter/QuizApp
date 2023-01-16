package com.example.quizapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.quizapp.databinding.FragmentHomeBinding
import com.example.quizapp.db.Question
import com.example.quizapp.db.QuestionDatabase
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var question: Question

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        /*launch {
            context?.let {
                QuestionDatabase(it).getQuestionDao()
                    .addQuestion(Question("1. Kotlin is developed by?", "Google", "JetBrains",
                        "Microsoft", "JetBrains", ""))
                QuestionDatabase(it).getQuestionDao()
                    .addQuestion(Question("2. Which of following is used to handle null exceptions in Kotlin?",
                        "Range", "Sealed Class", "Elvis Operator", "Elvis Operator", ""))
                QuestionDatabase(it).getQuestionDao()
                    .addQuestion(Question("3. Which file extension is used to save Kotlin files.",
                        ".java", ".kot", ".kt or .kts", ".kt or .kts", ""))
                QuestionDatabase(it).getQuestionDao()
                    .addQuestion(Question("4. All classes in Kotlin classes are by default?",
                        "public", "final", "sealed", "final", ""))
                QuestionDatabase(it).getQuestionDao()
                    .addQuestion(Question("5. What is correct way to create an arraylist in Kotlin?",
                        "enum class Color {RED, GREEN, BLUE}", "val list = arrayListOf(1, 2, 3)", "val set = hashSetOf(1, 2, 3)", "val list = arrayListOf(1, 2, 3)", ""))
                QuestionDatabase(it).getQuestionDao()
                    .addQuestion(Question("6. What is an immutable variable?",
                        "A variable that cannot change, read-only", "A variable that can be changed", "A variable used for string interpolation", "A variable that cannot change, read-only", ""))
                QuestionDatabase(it).getQuestionDao()
                    .addQuestion(Question("7. Which of follwing targets currently not supported by Kotlin?",
                        "LLVM", ".NET CLR", "Javascript", ".NET CLR", ""))
                QuestionDatabase(it).getQuestionDao()
                    .addQuestion(Question("8. How to make a multi lined comment in Kotlin?",
                        "//", "/* */", "/ multi line comment /", "/ multi line comment /", ""))
                QuestionDatabase(it).getQuestionDao()
                    .addQuestion(Question("9. How do you get the length of a string in Kotlin?",
                        "str.length", "length(str)", "str.lengthOf", "str.length", ""))
                QuestionDatabase(it).getQuestionDao()
                    .addQuestion(Question("10. Which of the followings constructors are available in Kotlin?",
                        "Primary constructor", "Secondary constructor", "Both 1 & 2", "Both 1 & 2", ""))
                QuestionDatabase(it).getQuestionDao()
                    .addQuestion(Question("11. Which of the following is not the basic data types in Kotlin?",
                        "Strings", "Arrays", "Lists", "Lists", ""))
                QuestionDatabase(it).getQuestionDao()
                    .addQuestion(Question("12. Which of following option is used to handle null exceptions in Kotlin?",
                        "Range", "Elvis Operator", "Sealed Class", "Elvis Operator", ""))
                QuestionDatabase(it).getQuestionDao()
                    .addQuestion(Question("13. Kotlin was developed under the .......... license.",
                        "Apache 1.0", "Apache 2.0", "Apache 1.1", "Apache 2.0", ""))
                QuestionDatabase(it).getQuestionDao()
                    .addQuestion(Question("14. There are two types of constructors in Kotlin which are-",
                        "Primary & Secondary constructor", "Default & No-arg constructor", "Parameterized & constant Constructor", "Primary & Secondary constructor", ""))
                QuestionDatabase(it).getQuestionDao()
                    .addQuestion(Question("15. Which of the following extension methods are used in Kotlin?",
                        "Read texts () & Headlines ()", "Buffer reader ()", "All of the above", "All of the above", ""))
                //QuestionDatabase(it).getQuestionDao().deleteTable()
            }
        }*/
        binding.apply {
            startQuiz.setOnClickListener{
                val direction = HomeFragmentDirections.actionHomeFragmentToQuestionsFragment()
                findNavController().navigate(direction)
            }
        }
        return binding.root
    }
}