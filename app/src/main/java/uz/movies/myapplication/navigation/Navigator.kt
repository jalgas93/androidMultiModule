package uz.movies.myapplication.navigation

import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import uz.movies.domain.domain.navigation.MovieListNavigation
import uz.movies.myapplication.R

class Navigator:MovieListNavigation {
    private var navController:NavController? = null


    fun bind(navController: NavController){
        this.navController = navController
    }

    fun unbind(){
        navController = null
    }
    override fun openMovie(id: Int) {
        val bundle = Bundle()
        bundle.putInt("movie_id",id)
        Log.d("Click","HERE")
        navController?.navigate(R.id.firstFragment)
    }
}