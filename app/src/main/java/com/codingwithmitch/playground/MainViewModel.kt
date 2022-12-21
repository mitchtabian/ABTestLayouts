package com.codingwithmitch.playground

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.codingwithmitch.playground.MainState.MainBackgroundColor.*

class MainViewModel: ViewModel() {

    val state: MutableState<MainState> = mutableStateOf(
        MainState(
            enableLegacy = true,
            mainBackgroundColor = WHITE,
            descriptionText = MainState.buildDescriptionText(WHITE),
            toggleBackgroundColor = ::toggleBackgroundColor,
            disableLegacyUI = ::disableLegacyUI,
            enableLegacyUI = ::enableLegacyUI
        )
    )

    private fun toggleBackgroundColor() {
        val newBackgroundColor = if (state.value.mainBackgroundColor == WHITE) {
            BLACK
        } else {
            WHITE
        }
        state.value = state.value.copy(
            mainBackgroundColor = newBackgroundColor,
            descriptionText = MainState.buildDescriptionText(newBackgroundColor),
        )
    }

    private fun disableLegacyUI() {
        state.value = state.value.copy(
            enableLegacy = false
        )
    }

    private fun enableLegacyUI() {
        state.value = state.value.copy(
            enableLegacy = true
        )
    }
}