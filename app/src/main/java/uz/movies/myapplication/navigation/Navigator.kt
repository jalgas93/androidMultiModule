package uz.movies.myapplication.navigation

import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import dagger.hilt.android.scopes.ActivityScoped
import uz.movies.domain.domain.navigation.MovieListNavigation
import uz.movies.myapplication.R
import javax.inject.Inject

@ActivityScoped
class Navigator @Inject constructor(
    private val navController: NavController
) : MovieListNavigation {

    override fun openMovie(id: Int) {
        val bundle = Bundle()
        bundle.putInt("movie_id",id)
        Log.d("Click","HERE")
        navController?.navigate(R.id.descriptionHomeFragment2,bundle)
    }
}
