package com.example.pokeem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OnBoard2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_board2)
        val Ok=findViewById(R.id.nextonb) as Button

        Ok.setOnClickListener{
            val intent = Intent(this, OnBoard3::class.java)
            startActivity(intent)
        }


    }
}