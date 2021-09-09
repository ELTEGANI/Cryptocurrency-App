package com.example.cryptocurrency.domain.use_cases.get_list_coins

import com.example.cryptocurrency.common.Resource
import com.example.cryptocurrency.data.remote.dto.toCoin
import com.example.cryptocurrency.domain.model.Coin
import com.example.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository){
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins()
            emit(Resource.Success(coins))
        }catch (e:HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An Error Occurred"))
        }catch (e:IOException){
            emit(Resource.Error<List<Coin>>("Couldn't Reach Server. Check your internet connection"))
        }
    }
}