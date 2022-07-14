package com.example.contextualcards.di

import com.example.contextualcards.data.RemoteDataSource
import com.example.contextualcards.data.apicall.UserApi
import com.example.contextualcards.utils.CShowProgress
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesAuthApi(remoteDataSource: RemoteDataSource): UserApi {
        return remoteDataSource.buildApi(UserApi::class.java)
    }

    @Provides
    fun provideProgressDialog() : CShowProgress {
        return CShowProgress()
    }

}