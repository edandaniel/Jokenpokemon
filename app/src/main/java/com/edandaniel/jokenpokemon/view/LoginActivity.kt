package com.edandaniel.jokenpokemon.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.edandaniel.jokenpokemon.R
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}
