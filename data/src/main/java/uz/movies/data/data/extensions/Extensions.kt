package uz.movies.data.data.extensions

import uz.movies.data.data.model.CoinModel
import uz.movies.domain.domain.model.Coin

fun CoinModel.toCoin(): Coin {
    return  Coin(
        id,isActive,name,rank,symbol
    )
}