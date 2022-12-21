package com.codingwithmitch.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.codingwithmitch.playground.domain.ComposeLayoutRunner
import com.codingwithmitch.playground.domain.LegacyLayoutRunner
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var mainComposeLayoutRunner: ComposeLayoutRunner<MainState>

    @Inject
    lateinit var mainLegacyLayoutRunner: LegacyLayoutRunner<MainState>

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (viewModel.state.value.removeConfigSyncToken == null) {
            viewModel.syncRemoteConfig()
        }
        setContent {
            val state = viewModel.state.value
            if (state.enableLegacy) {
                AndroidView(
                    modifier = Modifier.fillMaxSize(),
                    factory = { context ->
                        mainLegacyLayoutRunner.create(context, R.layout.activity_main)
                    },
                    update = { view ->
                        mainLegacyLayoutRunner.update(
                            view = view,
                            state = state
                        )
                    }
                )
            } else {
                mainComposeLayoutRunner.Create(state = state)
            }
        }
    }
}
