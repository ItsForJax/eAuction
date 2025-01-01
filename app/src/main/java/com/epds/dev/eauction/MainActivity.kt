package com.epds.dev.eauction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.epds.dev.eauction.screens.Homepage
import com.epds.dev.eauction.screens.SignIn
import com.epds.dev.eauction.ui.theme.EAuctionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val insets = WindowInsetsCompat.toWindowInsetsCompat(LocalView.current.rootWindowInsets)
            EAuctionTheme {
                Column(
                    Modifier
                        .background(Brush.linearGradient(colors = listOf(Color(0xFF2C2B2B), Color.Black)))
                        .padding(
                            top = with(LocalDensity.current) {
                                insets.getInsets(WindowInsetsCompat.Type.statusBars()).top.toDp()
                            },
                            bottom = with(LocalDensity.current) {
                                insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom.toDp()
                            }
                        )
                        .fillMaxSize()
                ) {
//                    SignIn()
                    Homepage()
                }

            }
        }
    }
}

