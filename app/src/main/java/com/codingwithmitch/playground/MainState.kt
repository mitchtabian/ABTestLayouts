package com.codingwithmitch.playground

data class MainState(
    val enableLegacy: Boolean,
    val mainBackgroundColor: MainBackgroundColor,
    val descriptionText: String,
    val toggleBackgroundColor: () -> Unit,
    val removeConfigSyncToken: String? = null
) {

    enum class MainBackgroundColor(val value: String) {
        BLACK("Black"),
        WHITE("White")
    }

    companion object {
        fun buildDescriptionText(
            mainBackgroundColor: MainBackgroundColor
        ) = "Background color is ${mainBackgroundColor.value}."
    }
}

