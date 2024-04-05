package uz.movies.myapplication.model

import uz.movies.domain.domain.model.Coin

data class CoinListState(
    val isLoading:Boolean = false,
    val coins:List<Coin> = emptyList(),
    val error:String = ""

)
