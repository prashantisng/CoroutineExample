 package com.example.coroutineex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

 class MainActivity : AppCompatActivity() {
    private var count=0;
    lateinit var btnCount:Button
    lateinit var btnDownloadUserData:Button
    lateinit var tvcount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCount=findViewById(R.id.btnCount)
        tvcount=findViewById(R.id.tvCount)
        btnDownloadUserData=findViewById(R.id.btnDownloadUserData)
        btnCount.setOnClickListener {
            tvcount.text=count++.toString()

        }
        btnDownloadUserData.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                btnDownloadUserData()
            }
        }

    }
     private fun btnDownloadUserData(){
         for (i in 1..20000){
             Log.i("Mytag","downloading user $i in ${Thread.currentThread().name}")
         }
     }
}


