package uz.movies.domain.domain.presentation

sealed class Screen {
    object FirstScreen : Screen()
    object SecondScreen : Screen()

    object ThirdScreen : Screen()
}