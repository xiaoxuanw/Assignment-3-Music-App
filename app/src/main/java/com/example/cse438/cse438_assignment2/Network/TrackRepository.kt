package com.example.cse438.cse438_assignment2.Network

import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.Data.Track
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response

class TrackRepository {
    //get the instance of retrofit
    val service = ApiClient.makeRetrofitService()

    //searches for track based on string value
    fun getTrackBySearch(resBody : MutableLiveData<List<Track>>, param : String, byArtist: Boolean) {
//        CoroutineScope(Dispatchers.IO).launch {
//            lateinit var response: Response<List<Track>>
//            if(byArtist) {
//                response =  service.getTrackByArtist(param)
//            } else {
//                response = service.getTrackBySearch(param)
//            }
//            //when the coroutine finishes
//            withContext(Dispatchers.Main){
//                try{
//                    //success case
//                    if(response.isSuccessful){
//                        println(response.body()?.size.toString() + " is the size")
//                        resBody.value = response.body()
//
//                    } else{
//                        //response error
//                        println("HTTP error")
//                    }
//                }catch (e: HttpException) {
//                    //http exception
//                    println("HTTP Exception")
//                } catch (e: Throwable) {
//                    //error
//                    println("Error")
//                }
//            }
//        }
   }
}