package com.example.cryptocurrency.data.repository


import com.example.cryptocurrency.data.remote.CoinPaprikaApi
import com.example.cryptocurrency.data.remote.dto.toCoin
import com.example.cryptocurrency.data.remote.dto.toCoinDetail
import com.example.cryptocurrency.domain.model.Coin
import com.example.cryptocurrency.domain.model.CoinDetail
import com.example.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject


class CoinRepositoryIml @Inject constructor(private val coinPaprikaApi: CoinPaprikaApi):CoinRepository{
    override suspend fun getCoins(): List<Coin> {
        return coinPaprikaApi.getCoins().map { it.toCoin() }
    }

    override suspend fun getCoinById(coinId: String): CoinDetail {
        return coinPaprikaApi.getCoinById(coinId).toCoinDetail()
    }
}