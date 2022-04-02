package com.example.capstoneproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstoneproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val intent = Intent(this, Create_Group::class.java)
            startActivity(intent)

        }
        binding.button2.setOnClickListener {
            val intent = Intent(this, Participate_Group::class.java)
            startActivity(intent)
        }

        binding.button3.setOnClickListener {
            val intent = Intent(this, Manage_Group::class.java)
            startActivity(intent)
        }

        binding.button4.setOnClickListener {
            val intent = Intent(this, Manage_Schedule::class.java)
            startActivity(intent)
        }
    }
}