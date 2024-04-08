package com.nurlan.data_mock.repository

import uz.movies.domain.domain.model.Coin
import uz.movies.domain.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor():CoinRepository{

    val coinList = arrayListOf(
        Coin("1",false,"Bitcoin",12,"BTC"),
        Coin("2",true,"Dogecoin",12,"DOGE"),
    )
    override suspend fun getCoins(): List<Coin> = coinList

}