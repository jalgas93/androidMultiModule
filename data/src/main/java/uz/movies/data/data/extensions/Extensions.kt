package uz.movies.data.data.extensions

import uz.movies.data.data.model.ResultModel
import uz.movies.domain.domain.model.Result

fun ResultModel.toMovie(): Result {
    return Result(
        adult,
        backdrop_path,
        genre_ids,
        id,
        original_language,
        original_title,
        overview,
        popularity,
        poster_path,
        release_date,
        title,
        video,
        vote_average,
        vote_count
    )
}