package com.example.cse438.cse438_assignment2.Network

import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.Data.Data
import com.example.cse438.cse438_assignment2.Data.Track
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response

class TrackRepository {
    //get the instance of retrofit
    private val service = ApiClient.makeRetrofitService()

    //searches for breweries based on string value
    fun getTrackBySearch(resBody : MutableLiveData<Data>, param : String) {
        //set the coroutine on a background thread
        CoroutineScope(Dispatchers.IO).launch {
            var response: Response<Data> = service.getTrackBySearchQuery(param)

            //when the coroutine finishes
            withContext(Dispatchers.Main){
                try{
                    //success case
                    if(response.isSuccessful){
                        //println(response.body()?.size.toString() + " is the size")
                        resBody.value = response.body()
                        println("success")
                        println(response)

                    } else{
                        //response error
                        println("HTTP error")
                    }
                }catch (e: HttpException) {
                    //http exception
                    println("HTTP Exception")
                } catch (e: Throwable) {
                    //error
                    println("Error")
                }
            }
        }
    }
}