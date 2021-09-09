package com.example.cryptocurrency.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptocurrency.presentation.coin_details.components.CoinDetailScreen
import com.example.cryptocurrency.presentation.coin_list.components.CoinListScreen
import com.example.cryptocurrency.presentation.theme.CryptocurrencyAppYTTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppYTTheme() {
                Surface(color = MaterialTheme.colors.background) {
                  val navController = rememberNavController()
                  NavHost(
                      navController = navController,
                      startDestination = Screen.CoinListScreen.route
                  ){
                      composable(
                       route = Screen.CoinListScreen.route
                      ){
                          CoinListScreen(navController)
                      }
                      composable(
                          route = Screen.CoinDetailScreen.route+"/{coinId}"
                      ){
                          CoinDetailScreen()
                      }
                  }
                }
            }
        }
    }
}
