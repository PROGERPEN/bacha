package com.gooutnow.love

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class SurveyActivity : AppCompatActivity() {

    lateinit var questionButton: Button

    private lateinit var HeightSeekBar: SeekBar
    private lateinit var WeightSeekBar: SeekBar
    lateinit var height: TextView
    lateinit var weight: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)

        HeightSeekBar = findViewById(R.id.height_bar)
        WeightSeekBar = findViewById(R.id.weight_bar)
        height = findViewById(R.id.textView5_height)
        weight = findViewById(R.id.textView8_weight)
        questionButton = findViewById(R.id.questionButton)

        WeightSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                weight.text = seekBar.progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                weight.text = seekBar.progress.toString()
            }

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                weight.text = seekBar.progress.toString()
            }

        })

        HeightSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                height.text = (seekBar.progress + 140).toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                height.text = (seekBar.progress + 140).toString()
            }

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                height.text = (seekBar.progress + 140).toString()
            }

        })

        questionButton.setOnClickListener {
            startActivity(Intent(this@SurveyActivity, WhatAreYouIshesh::class.java))
        }
    }
}
