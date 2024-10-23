package com.abdo.e_commerce_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdo.e_commerce_compose.info.MapProvider
import com.abdo.e_commerce_compose.ui.theme.ECommerceComposeTheme
import com.abdo.e_commerce_compose.provider.DataProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ECommerceComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Base Url: ${BuildConfig.BASE_URL}",
            modifier = modifier
        )
        Text(
            text = "CAN_CLEAR_CACHE: ${BuildConfig.CAN_CLEAR_CACHE}",
            modifier = modifier
        )
        Text(
            text = "DB_VERSION: ${BuildConfig.DB_VERSION}",
            modifier = modifier
        )
        Text(
            text = "MAP_KEY: ${BuildConfig.MAP_KEY}",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ECommerceComposeTheme {
        Greeting()
    }
}