package com.codingwithmitch.playground.domain

import android.content.Context
import android.view.View
import androidx.annotation.LayoutRes

interface LegacyLayoutRunner<T> {

    fun create(context: Context, @LayoutRes layoutId: Int): View

    fun update(view: View, state: T)
}