package com.adia.laboratoire1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        var gotostatic=findViewById<Button>(R.id.btn1)
        var gotodynamique=findViewById<Button>(R.id.btn2)
        gotostatic.setOnClickListener {
            val intent = Intent(this, StaticHostActivity::class.java)
            startActivity(intent)
        }
        gotodynamique.setOnClickListener {
            val intent = Intent(this, DynamicHostActivity::class.java)
            startActivity(intent)
        }
    }
}