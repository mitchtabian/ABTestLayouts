package com.codingwithmitch.playground

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.codingwithmitch.playground.MainState.MainBackgroundColor.*
import com.codingwithmitch.playground.legacy.LegacyLayoutRunner
import com.codingwithmitch.playground.R as mainR

class MainLayoutRunner(
    private val legacyLayoutRunner: LegacyLayoutRunner
){
    @Composable
    fun createLegacyLayout(state: MainState) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                legacyLayoutRunner.create(context)
            },
            update = { view ->
                legacyLayoutRunner.update(
                    view = view,
                    state = state
                )
            }
        )
    }

    @Composable
    fun createComposeLayout(state: MainState) {
        val backgroundColor = if (state.mainBackgroundColor == WHITE) {
            Color.White
        } else {
            Color.Black
        }
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = backgroundColor
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                val textColor = if (state.mainBackgroundColor == WHITE) {
                    Color.Black
                } else {
                    Color.White
                }
                Text(
                    text = state.descriptionText,
                    color = textColor,
                    fontSize = 18.sp
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        text = stringResource(mainR.string.toggle_background_color),
                        color = textColor,
                        fontSize = 14.sp,
                    )
                    Switch(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        checked = state.mainBackgroundColor == WHITE,
                        onCheckedChange = {
                            state.toggleBackgroundColor()
                        },
                    )
                }
                Button(
                    modifier = Modifier.padding(top = 16.dp),
                    onClick = {
                        state.enableLegacyUI()
                    },
                ) {
                    Text(
                        text = stringResource(id = mainR.string.enable_legacy_ui),
                        color = Color.White,
                        fontSize = 14.sp,
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 32.dp),
                    text = stringResource(id = mainR.string.compose_text),
                    color = colorResource(id = mainR.color.red),
                    fontSize = 24.sp
                )
            }
        }
    }
}