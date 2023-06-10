package com.example.coroutineex

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SecondActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.second_layout)

        CoroutineScope(IO).launch {
            Log.i("MyTag","calculation is started...")
            val stock1=async {  getStock1()}
            val stock2=async {getStock2()  }
            val total=stock1.await()+stock2.await()
            Log.i("MyTag","Total is"+total)  //parallel computation
        }
    }
    private suspend fun getStock1() :Int{
        delay(8000)
        Log.i("MyTag","stock 2 is returned")
        return 5500
    }
    private suspend fun getStock2() :Int{
        delay(8000)
        Log.i("MyTag","stock 2 is returned")
        return 5100
    }
}