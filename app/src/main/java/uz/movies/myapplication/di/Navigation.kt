package uz.movies.myapplication.di

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import uz.movies.domain.domain.navigation.MovieListNavigation
import uz.movies.myapplication.R
import uz.movies.myapplication.navigation.Navigator

@Module
@InstallIn(ActivityComponent::class)
object NavigationModule {
    @Provides
    fun navController(activity: FragmentActivity): NavController {
        return NavHostFragment.findNavController(activity.supportFragmentManager.findFragmentById(R.id.nav_host_fragment)!!)
    }
}

@Module
@InstallIn(ActivityComponent::class)
abstract class MovieListModule {
    @Binds
    abstract fun movieList(navigator: Navigator): MovieListNavigation
}
