package com.example.calc


import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val text: TextView = findViewById(R.id.textAbout)
        text.text="Калькулятор разработан студентами БИВТ-АСО: Мирошников Владислав Андреевич, Омельяненко Алексей Игоревич"
        }
    }