package uz.movies.data.data.api

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import uz.movies.data.data.model.PopularMovie
import uz.movies.data.data.model.ResultModel
import uz.movies.domain.domain.common.Constants.API_KEY

interface TheMovieApi {

    @Headers(
        "accept: application/json",
        "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmMTczZDVhYzEwNzk5YWFiNGQ0MjVhMjgzNDZkYjc4ZSIsInN1YiI6IjYxNjQ0NTA4NTA3MzNjMDA2NDgzZjIyMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.He2bIuySkIllZAmewGYfqypxUNdzMb_Vt6DIlzcfCAc",
    )
    @GET("3/movie/popular")
    suspend fun getPopularMovie(
        @Query("page") page:Int = 1,
        @Query("language") language: String ="ru-RU",
        @Query("api_key") apiKey:String = API_KEY
    ):PopularMovie
}