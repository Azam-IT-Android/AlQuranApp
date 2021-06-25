package com.ismail.creatvt.alquranapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.ismail.creatvt.alquranapp.data.DataItem
import com.ismail.creatvt.alquranapp.data.SurahListResponse
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnSurahClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val queue = Volley.newRequestQueue(this)
        val url = "https://api.quran.sutanlab.id/surah"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
                Request.Method.GET, // Request Method
                url,                // URL
                {
                    // Success Listener
                    val responseObject = Gson().fromJson(it, SurahListResponse::class.java)
                    if(responseObject.data != null){
                        surah_list_rv.adapter = SurahListAdapter(responseObject.data, this)
                        surah_list_rv.layoutManager = LinearLayoutManager(this)
                    }
                },
                {
                    // Error Listener
                    Log.d("MainActivity", "Error received: $it")
                })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)

    }

    override fun onSurahClick(item: DataItem) {
        val intent = Intent(this, SurahInfoActivity::class.java)
        intent.putExtra("number", item.number)
        startActivity(intent)
    }
}