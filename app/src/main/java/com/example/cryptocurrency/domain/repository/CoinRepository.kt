package com.example.cryptocurrency.domain.repository

import com.example.cryptocurrency.domain.model.Coin
import com.example.cryptocurrency.domain.model.CoinDetail


interface CoinRepository {
  suspend fun getCoins() : List<Coin>
  suspend fun getCoinById(coinId:String): CoinDetail
}