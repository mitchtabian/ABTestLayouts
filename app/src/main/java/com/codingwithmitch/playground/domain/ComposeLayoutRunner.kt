package com.codingwithmitch.playground.domain

import androidx.compose.runtime.Composable

interface ComposeLayoutRunner<T> {

    @Composable
    fun Create(state: T)
}