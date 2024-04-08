package uz.movies.domain.domain.presentation

import android.app.Activity

interface Navigator {
    fun navigate(activity: Activity)

    interface Provider {
        fun get(screen: Screen):Navigator
    }

}