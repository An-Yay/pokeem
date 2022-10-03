package com.example.pokeem

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton

class SignupActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup2)
//        val back = findViewById(R.id.back) as Button
//        val next=findViewById(R.id.next) as Button
        val bk = findViewById(R.id.bk) as ImageButton
        val nxt=findViewById(R.id.nxt) as Button
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.resources.getColor(R.color.primBg)



        bk.setOnClickListener{
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)

        }
        nxt.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}