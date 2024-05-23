package com.example.przewodnikturystyczny

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    lateinit var topAppBar: MaterialToolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        topAppBar = findViewById(R.id.topAppBar);

        topAppBar.setNavigationOnClickListener {
            Toast.makeText(this, "aaa", Toast.LENGTH_SHORT).show()
        }

        topAppBar.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId){
                R.id.forward -> {
                    Toast.makeText(this, "bbbb", Toast.LENGTH_SHORT).show()
                    true
                }
                else ->{
                    false
                }
            }
        }

    }
}