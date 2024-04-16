package uz.movies.domain.domain.repository

import uz.movies.domain.domain.model.Result

interface MovieRepository {
    suspend fun getPopular(): List<Result>
}