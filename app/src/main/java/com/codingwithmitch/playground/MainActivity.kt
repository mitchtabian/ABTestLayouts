package com.codingwithmitch.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.codingwithmitch.playground.legacy.LegacyLayoutRunner

class MainActivity : ComponentActivity() {

    private val mainLayoutRunner = MainLayoutRunner(
        legacyLayoutRunner = LegacyLayoutRunner(R.layout.activity_main)
    )
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state = viewModel.state.value
            if (state.enableLegacy) {
                mainLayoutRunner.createLegacyLayout(state = state)
            } else {
                mainLayoutRunner.createComposeLayout(state = state)
            }
        }
    }
}
