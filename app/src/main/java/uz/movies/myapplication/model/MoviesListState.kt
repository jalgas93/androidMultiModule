package uz.movies.myapplication.model

import uz.movies.domain.domain.model.Result

data class MoviesListState(
    val isLoading:Boolean = false,
    val movies:List<Result> = emptyList(),
    val error:String = ""

)
