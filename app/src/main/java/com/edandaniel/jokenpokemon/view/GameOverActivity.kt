package com.edandaniel.jokenpokemon.view

import android.app.Activity
import android.app.ProgressDialog
import android.app.VoiceInteractor
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.edandaniel.jokenpokemon.R
import com.edandaniel.jokenpokemon.utils.BASE_URL
import kotlinx.android.synthetic.main.activity_game_over.*
import org.json.JSONObject
import com.android.volley.AuthFailureError



class GameOverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)
        btMenuPrincipal.setOnClickListener{
            val intent = Intent(this, MenuActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }

        btEnviar.setOnClickListener {
            val url_api = "/jokenpokemon/pontuacao"
            val requestqueue = Volley.newRequestQueue(this)

            val jsonObjReq = object : StringRequest(Request.Method.POST,
                    BASE_URL + url_api,
                     Response.Listener {
                         response ->
                         println("RESPONSE: " + response.toString())
                         Toast.makeText(this@GameOverActivity, "Ranking atualizado com sucesso!" + response.toString(), Toast.LENGTH_SHORT).show()
                    },
                    Response.ErrorListener {
                       response ->
                        println("RESPONSE: " + response.toString())
                        Toast.makeText(this@GameOverActivity, "Deu ruim!!" + response.toString(), Toast.LENGTH_SHORT).show()
                    }){
                @Throws(AuthFailureError::class)
                override fun getBody(): ByteArray {
                    val params2 = HashMap<String, String>()
                    params2["nome"] = edtName.text.toString()
                    params2["pontos"] = txtRecord.text.toString()
                    return JSONObject(params2).toString().toByteArray()
                }

                override fun getBodyContentType(): String {
                    return "application/json"
                }
            }
            requestqueue.add(jsonObjReq)
            val intent = Intent(this, GameActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
           finish()
        }
    }
}
