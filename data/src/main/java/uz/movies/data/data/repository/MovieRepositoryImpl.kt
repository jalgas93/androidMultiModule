package uz.movies.data.data.repository

import android.util.Log
import uz.movies.data.data.api.TheMovieApi
import uz.movies.data.data.extensions.toMovie
import uz.movies.domain.domain.model.Result
import uz.movies.domain.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: TheMovieApi
) : MovieRepository {


    override suspend fun getPopular(): List<Result> {
        return api.getPopularMovie().results.map {
            it.toMovie()
        }

    }

}