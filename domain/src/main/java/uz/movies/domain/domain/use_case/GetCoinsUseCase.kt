package uz.movies.domain.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.movies.domain.domain.common.Resource
import uz.movies.domain.domain.model.Coin
import uz.movies.domain.domain.repository.CoinRepository
import java.io.IOException

import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository,
) {
 operator  fun invoke():Flow<Resource<List<Coin>>> = flow {
     try {
         emit(Resource.Loading())
         val coins = repository.getCoins()
         emit(Resource.Success(coins))
     }catch (e:IOException){
         emit(Resource.Error("Couldn't reach server. Check your internet "))
     }
 }
}