package com.example.meyman.presentation.ui.screens.room_page.tablayout.review

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meyman.domain.usecases.FetchReviewUseCase
import com.example.meyman.domain.utils.Either
import com.example.meyman.presentation.models.ReviewItemUI
import com.example.meyman.presentation.models.toUI
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

    private val _reviewState = MutableStateFlow<UIState<List<ReviewItemUI>>>(UIState.Loading())
    val animeState get() = _reviewState.asStateFlow()

    init {
        fetchAnime()
    }

    private fun fetchAnime() {
        viewModelScope.launch {
            fetchReviewUseCase().collect {
                when (it) {
                    is Either.Left -> {
                        it.message?.let { error ->
                            _reviewState.value = UIState.Error(error)
                        }
                    }
                    is Either.Right -> {
                        it.data?.let {
                            _reviewState.value = UIState.Success(it.map { review ->
                                review.toUI()
                            })
                        }
                    }
                }
            }
        }
    }
}