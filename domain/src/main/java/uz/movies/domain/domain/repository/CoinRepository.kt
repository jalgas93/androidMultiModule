package uz.movies.domain.domain.repository

import uz.movies.domain.domain.model.Coin

interface CoinRepository {
    suspend fun getCoins(): List<Coin>
}