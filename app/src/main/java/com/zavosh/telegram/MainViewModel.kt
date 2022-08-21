package com.composesample

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val connectionState = mutableStateOf("connecting")

    init {
        connectionState.value = "Telegram"
    }
}