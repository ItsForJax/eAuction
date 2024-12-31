package com.epds.dev.eauction.screens

import com.epds.dev.eauction.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowInsetsCompat

@Composable
fun SignIn() {
    val insets = WindowInsetsCompat.toWindowInsetsCompat(LocalView.current.rootWindowInsets)
    Column(
        Modifier
            .background(Brush.linearGradient(colors = listOf(Color(0xFF2C2B2B), Color.Black)))

            .padding(
                top = with(LocalDensity.current) {
                    insets.getInsets(WindowInsetsCompat.Type.statusBars()).top.toDp()
                },
            )
            .padding(horizontal = 24.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .weight(11f)
                .fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            ) {
                Image(painterResource(
                    id = R.drawable.eauction_logo ),
                    contentDescription = "eAuction Logo",
                    modifier = Modifier.width(214.dp))
            }
            CustomButton(
                title = "Sign In",
                onClick = {
                    println("Hello")
                }
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(4f)
                .fillMaxSize()
        ) {
            Text(
                text = "or",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(vertical = 24.dp)
            )

            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(10.dp))
                Image(painterResource(
                    id = R.drawable.facebook ),
                    contentDescription = "facebook Logo",
                    modifier = Modifier.height(33.5.dp))
                Spacer(modifier = Modifier.width(30.dp))
                Image(painterResource(
                    id = R.drawable.google ),
                    contentDescription = "google Logo",
                    modifier = Modifier.height(32.5.dp))
                Spacer(modifier = Modifier.width(30.dp))
                Column {
                    Image(painterResource(
                        id = R.drawable.apple ),
                        contentDescription = "apple Logo",
                        modifier = Modifier.height(35.5.dp))
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
        }

    }
}

@Composable
fun CustomButton(title: String, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(
                Brush.linearGradient(
                    colors = listOf(Color(0xFFC5AA72), Color(0xFFFFCC5D))
                ),
                shape = RoundedCornerShape(17.dp)
            )
            .clickable(
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            )
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2D2C2C)
        )
    }
}
