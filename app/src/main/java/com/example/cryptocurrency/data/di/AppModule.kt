package com.example.cryptocurrency.data.di

import com.example.cryptocurrency.common.Constant.BASE_URL
import com.example.cryptocurrency.data.remote.CoinPaprikaApi
import com.example.cryptocurrency.data.repository.CoinRepositoryIml
import com.example.cryptocurrency.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
   @Provides
   @Singleton
   fun providePaprikaApi() : CoinPaprikaApi {
       return Retrofit.Builder()
             .baseUrl(BASE_URL)
             .addConverterFactory(GsonConverterFactory.create())
             .build()
             .create(CoinPaprikaApi::class.java)
   }

   @Provides
   @Singleton
   fun provideCoinRepository(coinPaprikaApi: CoinPaprikaApi):CoinRepository{
       return CoinRepositoryIml(coinPaprikaApi)
   }

}