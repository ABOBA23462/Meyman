package com.example.meyman.presentation.ui.screens.hotel_page.rooms

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meyman.domain.usecases.FetchChooseRoomUseCase
import com.example.meyman.domain.utils.Either
import com.example.meyman.presentation.models.ResultRoomUI
import com.example.meyman.presentation.models.toUI
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomsViewModel @Inject constructor(
    private val chooseRoomUseCase: FetchChooseRoomUseCase
): ViewModel() {

    private val _chooseRoomState = MutableStateFlow<UIState<List<ResultRoomUI>>>(UIState.Loading())
    val chooseRoomState get() = _chooseRoomState.asStateFlow()

    fun getChooseRoomState(){
        viewModelScope.launch {
            chooseRoomUseCase.invoke().collect{
                when(it){
                    is Either.Left -> {
                        _chooseRoomState.value = UIState.Error(it.message!!)
                        Log.e("ololo", "getChooseRoomState: ${it.message}", )
                    }
                    is Either.Right -> {
                        _chooseRoomState.value = UIState.Success(it.data!!.map { it.toUI() })
                        Log.e("ololo", "getChooseRoomState: ${it.data}", )
                    }
                }
            }
        }
    }
}