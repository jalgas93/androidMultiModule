package uz.movies.data.data.api

import retrofit2.http.GET
import uz.movies.data.data.model.CoinModel

interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins():List<CoinModel>
}