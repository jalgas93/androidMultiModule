package com.nurlan.data_mock.repository

import uz.movies.domain.domain.model.Result
import uz.movies.domain.domain.repository.MovieRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor() : MovieRepository {

    val coinList = arrayListOf(
        Result(
            backdrop_path = "",
            title = "",
            id = 4,
            adult = true,
            genre_ids = listOf(1,2),
            original_title = "3sfsdf",
            original_language = "ru",
            overview = "dfdsf",
            popularity = 3.5,
            poster_path = "dsfsdf",
            release_date = "dsfdsf",
            video = false,
            vote_average = 3.4,
            vote_count = 4
        ),

    )

    override suspend fun getPopular(): List<Result> = coinList

}