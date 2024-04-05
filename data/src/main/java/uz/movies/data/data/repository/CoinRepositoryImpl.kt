package uz.movies.data.data.repository

import uz.movies.data.data.api.CoinPaprikaApi
import uz.movies.data.data.extensions.toCoin
import uz.movies.domain.domain.model.Coin
import uz.movies.domain.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api:CoinPaprikaApi
):CoinRepository {
    override suspend fun getCoins(): List<Coin> {
        return  api.getCoins().map {
            it.toCoin()
        }
    }

}