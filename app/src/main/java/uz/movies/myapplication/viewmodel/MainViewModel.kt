package uz.movies.myapplication.viewmodel

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.movies.domain.domain.common.Resource
import uz.movies.domain.domain.presentation.Screen
import uz.movies.domain.domain.use_case.GetCoinsUseCase
import uz.movies.myapplication.model.CoinListState
import uz.movies.myapplication.presentation.Event
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
) : ViewModel() {
    private val _state = MutableLiveData<CoinListState>()
    val state: LiveData<CoinListState> = _state

    val navigateTo = MutableLiveData<Event<Screen>>()

    fun onButtonClicks() {
        navigateTo.value = Event(Screen.FirstScreen)
    }
    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = CoinListState(error = result.message?: "An unexpected error occurred!")
                }

                is Resource.Loading -> {
                 _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}