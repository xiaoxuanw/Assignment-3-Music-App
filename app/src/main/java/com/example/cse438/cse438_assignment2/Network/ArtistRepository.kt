package com.example.cse438.cse438_assignment2.Network

import androidx.lifecycle.MutableLiveData
import com.example.cse438.cse438_assignment2.Data.Chart
import com.example.cse438.cse438_assignment2.Data.ChartArtist
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response

class ArtistRepository { // search for chart
    private val service = ApiArtistClient.makeRetrofitService()

    fun getArtistByChart(resBody : MutableLiveData<ChartArtist>) {
        //set the coroutine on a background thread
        CoroutineScope(Dispatchers.IO).launch {
            var response: Response<ChartArtist> = service.getArtistByChart()

            //when the coroutine finishes
            withContext(Dispatchers.Main){
                try{
                    //success case
                    if(response.isSuccessful){
                        //println(response.body()?.size.toString() + " is the size")
                        resBody.value = response.body()
                        println("success")
                        //println(response)

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
    fun getArtistByArtistID(resBody : MutableLiveData<ChartArtist>, param: String) {
        //set the coroutine on a background thread
        CoroutineScope(Dispatchers.IO).launch {
            var response: Response<ChartArtist> = service.getArtistByArtistID(param)

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