package com.example.pokeem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OnBoard1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_board1)

        val getStarted = findViewById(R.id.getStarted) as Button
        getStarted.setOnClickListener{
            val intent = Intent(this, OnBoard2::class.java)
            startActivity(intent)
        }

    }
}