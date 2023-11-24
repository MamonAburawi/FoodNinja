package com.example.foodninja.di

import android.content.Context
import com.example.foodninja.utils.SharePrefApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ActivityComponent::class)
object AppModules {

    @Provides
    @Singleton
    fun getSharePref(@ApplicationContext context: Context) = SharePrefApp(context)

}