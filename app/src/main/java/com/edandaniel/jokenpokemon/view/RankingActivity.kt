package com.edandaniel.jokenpokemon.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.edandaniel.jokenpokemon.R
import com.edandaniel.jokenpokemon.utils.BASE_URL
import com.edandaniel.jokenpokemon.utils.CustomAdapter
import com.edandaniel.jokenpokemon.view.model.Points
import kotlinx.android.synthetic.main.activity_ranking.*

class RankingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)
        var ranking =  findViewById(R.id.listView) as ListView
        var arrayRanking: ArrayList<Points> = ArrayList()
        val url_api = "/jokenpokemon/pontuacao"
        val requestqueue = Volley.newRequestQueue(this)
        val request = JsonArrayRequest(Request.Method.GET, BASE_URL + url_api,
                       null,
                Response.Listener {
                    response ->
                    var i:Int = 0
                    for (i in 0..response.length()-1) {
                        arrayRanking.add(Points(response.getJSONObject(i).getString("nome"),response.getJSONObject(i).getString("pontos"),response.getJSONObject(i).getString("id")))
                   }
                    listView.adapter = CustomAdapter(applicationContext, arrayRanking)
                },
                Response.ErrorListener{
                    response ->
                    Toast.makeText(this@RankingActivity, "Deu ruim!!" + response.toString(), Toast.LENGTH_SHORT).show()
                }
        )
        requestqueue.add(request)
    }
}
