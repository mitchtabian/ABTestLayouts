package com.codingwithmitch.playground.di

import com.codingwithmitch.playground.MainState
import com.codingwithmitch.playground.domain.ComposeLayoutRunner
import com.codingwithmitch.playground.domain.LegacyLayoutRunner
import com.codingwithmitch.playground.layout_runners.MainComposeLayoutRunner
import com.codingwithmitch.playground.layout_runners.MainLegacyLayoutRunner
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindComposeLayoutRunner(
        layoutRunner: MainComposeLayoutRunner
    ): ComposeLayoutRunner<MainState>

    @Binds
    abstract fun bindLegacyLayoutRunner(
        layoutRunner: MainLegacyLayoutRunner
    ): LegacyLayoutRunner<MainState>
}