package uz.movies.domain.domain.use_case

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.movies.domain.domain.common.Resource
import uz.movies.domain.domain.model.Result
import uz.movies.domain.domain.repository.MovieRepository
import java.io.IOException

import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository,
) {
 operator  fun invoke():Flow<Resource<List<Result>>> = flow {
     try {
         emit(Resource.Loading())
         val movies = repository.getPopular()
         Log.i("jalgas", movies.toString())
         emit(Resource.Success(movies))
     }catch (e:IOException){
         emit(Resource.Error("Couldn't reach server. Check your internet "))
     }
 }
}