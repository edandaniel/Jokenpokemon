package com.edandaniel.jokenpokemon.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.edandaniel.jokenpokemon.R
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btJogar.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        btGameOver.setOnClickListener {
            val intent = Intent(this, GameOverActivity::class.java)
            startActivity(intent)
        }

        btRanking.setOnClickListener {
            val intent = Intent(this, RankingActivity::class.java)
            Log.e("Start Ranking Activity","Start Ranking Activity")
            startActivity(intent)
        }

        btSobre.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        btSair.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
