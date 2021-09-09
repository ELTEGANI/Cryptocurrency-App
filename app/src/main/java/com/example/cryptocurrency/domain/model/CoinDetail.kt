package com.example.cryptocurrency.domain.model

import com.example.cryptocurrency.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val tags: List<String>,
    val team: List<TeamMember>,
    val isActive: Boolean,
    )
