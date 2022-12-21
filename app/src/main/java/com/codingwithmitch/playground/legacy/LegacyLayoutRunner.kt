package com.codingwithmitch.playground.legacy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.codingwithmitch.playground.MainState
import com.codingwithmitch.playground.MainState.MainBackgroundColor.*
import com.codingwithmitch.playground.R

class LegacyLayoutRunner(
    @LayoutRes val layoutId: Int,
) {
    fun create(context: Context): View {
        return LayoutInflater.from(context).inflate(layoutId, null, false)
    }

    fun update(
        view: View,
        state: MainState
    ) {
        val switch: Switch = view.findViewById(R.id.background_switch)
        val textView: TextView = view.findViewById(R.id.text_view)
        val constraintMain: ConstraintLayout = view.findViewById(R.id.constraint_main)
        val disableLegacyButton: Button = view.findViewById(R.id.disable_legacy)
        switch.isChecked = state.mainBackgroundColor == WHITE
        val textColor = if (state.mainBackgroundColor == WHITE) {
            R.color.black
        } else {
            R.color.white
        }
        switch.setTextColor(ContextCompat.getColor(view.context, textColor))
        textView.setTextColor(ContextCompat.getColor(view.context, textColor))
        constraintMain.setBackgroundColor(
            ContextCompat.getColor(
                view.context,
                if (state.mainBackgroundColor == WHITE) {
                    R.color.white
                } else {
                    R.color.black
                }
            )
        )
        textView.text = state.descriptionText
        switch.setOnClickListener {
            state.toggleBackgroundColor()
        }
        disableLegacyButton.setOnClickListener {
            state.disableLegacyUI()
        }
    }
}