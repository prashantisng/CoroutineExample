package com.example.coroutineex

import kotlinx.coroutines.*

class UserDataManager2 {
    var count=0
    lateinit var deferred:Deferred<Int>
     suspend fun getTotalUserCount():Int{
        coroutineScope {
                launch (Dispatchers.IO){
                    delay(1000)
                    count=50

                }
             deferred= CoroutineScope(Dispatchers.IO).async {
                delay(3000)
                return@async 70
            }
        }
        return count +deferred.await()
    }
}