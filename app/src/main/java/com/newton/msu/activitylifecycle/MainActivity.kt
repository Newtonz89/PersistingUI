package com.bignerdranch.android.geoquiz

import android.app.Activity
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.bignerdranch.android.geoquiz.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private lateinit var trueButton : Button
    //private lateinit var falseButton : Button

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    private var currentIndex = 0
    private lateinit var questionTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //trueButton = findViewById(R.id.true_button)
        //falseButton = findViewById(R.id.false_button)


        //Exercise 2, adding next to textview
        questionTextView = findViewById(R.id.question_textview)
        questionTextView.setOnClickListener{
            currentIndex = (currentIndex + 1) % questionBank.size

            updateQuestion()
        }


        binding.trueButton.setOnClickListener{
            val snackBar = Snackbar.make(
                it,
                "Correct",
                Snackbar.LENGTH_LONG
            )
            snackBar.show()
        }
        binding.falseButton.setOnClickListener{
            val snackBar = Snackbar.make(
                it,
                "Incorrect",
                Snackbar.LENGTH_LONG
            )
            snackBar.setTextColor(Color.BLACK)
            snackBar.setBackgroundTint(Color.RED)
            snackBar.show()
        }

        binding.nextButton.setOnClickListener{
            currentIndex = (currentIndex + 1) % questionBank.size
            //val questionResId = questionBank[currentIndex].textResId
            //binding.questionTextview.setText(questionResId)
            updateQuestion()
        }

        binding.prevButton.setOnClickListener{
            currentIndex = (currentIndex - 1) % questionBank.size
            //val questionResId = questionBank[currentIndex].textResId
            //binding.questionTextview.setText(questionResId)
            updateQuestion()}

        updateQuestion()

    }
    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextview.setText(questionTextResId)
    }
}

