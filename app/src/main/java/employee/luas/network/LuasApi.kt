package employee.luas.network

import employee.luas.model.StopInfo
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Sibaprasad Mohanty on 20/2/21.
 * prasad.mohanty2011@gmail.com
 */

interface LuasApi {

    @GET("/xml/get.ashx")
    fun getForecast(
        @Query("action") action: String = "forecast",
        @Query("encrypt") encrypt: Boolean = false,
        @Query("stop") stop: String
    ): Single<StopInfo>

    @GET("/xml/get.ashx")
    suspend fun getForecastViaCoroutines(
        @Query("action") action: String = "forecast",
        @Query("encrypt") encrypt: Boolean = false,
        @Query("stop") stop: String
    ): StopInfo
}