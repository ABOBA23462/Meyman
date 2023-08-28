package com.example.meyman.presentation.ui.screens.chooseRoom

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meyman.domain.usecases.ChooseRoomUseCase
import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.ChooseRoomModel
import com.example.meyman.domain.utils.models.ResultDomain
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChooseRoomViewModel @Inject constructor(
    private val chooseRoomUseCase: ChooseRoomUseCase
): ViewModel() {

    private val _chooseRoomState = MutableStateFlow<UIState<List<ResultDomain>>>(UIState.Loading())
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
                        _chooseRoomState.value = UIState.Success(it.data!!)
                        Log.e("ololo", "getChooseRoomState: ${it.data}", )
                    }
                }
            }
        }
    }

}