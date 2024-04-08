package uz.movies.myapplication.presentation



import uz.movies.domain.domain.presentation.Navigator
import uz.movies.domain.domain.presentation.Screen
import uz.movies.myapplication.view.MainActivity


class DefaultNavigatorProvider  : Navigator.Provider{
    override fun get(screen: Screen): Navigator = when (screen) {
       // is Screen.FirstScreen -> MainActivity.GoToFirstScreen
       // is Screen.SecondScreen -> MainActivity.GoToFirstScreen
      //  is Screen.ThirdScreen -> GoToSecondActivity(screen.userId)
        Screen.SecondScreen -> TODO()
        Screen.ThirdScreen -> TODO()
        Screen.FirstScreen -> TODO()
    }
}