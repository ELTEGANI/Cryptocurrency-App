package com.example.cryptocurrency.domain.use_cases.get_coin

import com.example.cryptocurrency.domain.model.CoinDetail


data class CoinDetailState(
    val isLoading:Boolean  = false,
    val coin : CoinDetail? = null,
    val error  : String = ""
)
