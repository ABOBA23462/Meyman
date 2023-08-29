package com.example.meyman.presentation.ui.screens.room_page.tablayout.review

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meyman.domain.usecases.FetchReviewUseCase
import com.example.meyman.domain.utils.Either
import com.example.meyman.presentation.models.review.ResultsReviewItemUI
import com.example.meyman.presentation.models.review.toUI
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReviewViewModel @Inject constructor(
    private val fetchReviewUseCase: FetchReviewUseCase
) : ViewModel() {
    private val _reviewState = MutableStateFlow<UIState<List<ResultsReviewItemUI>>>(UIState.Loading())
    val reviewState get() = _reviewState.asStateFlow()

    fun getReviewState(){
        viewModelScope.launch {
            fetchReviewUseCase.invoke().collect{
                when(it){
                    is Either.Left -> {
                        _reviewState.value = UIState.Error(it.message!!)
                        Log.e("lox", "getChooseRoomState: ${it.message}", )
                    }
                    is Either.Right -> {
                        _reviewState.value = UIState.Success(it.data!!.map { it.toUI() })
                        Log.e("lox", "getChooseRoomState: ${it.data}", )
                    }

                    else -> {}
                }
            }
        }
    }

}