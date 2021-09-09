package com.example.cryptocurrency.domain.use_cases.get_list_coins

import com.example.cryptocurrency.domain.model.Coin


data class CoinListState(
    val isLoading:Boolean  = false,
    val coins : List<Coin> = emptyList(),
    val error  : String = ""
)
