package com.epds.dev.eauction.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddAuction1() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        Text(text = "Add Auction",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color(0xFFC5AA73),
            modifier = Modifier.padding(vertical = 20.dp)
        )

        Row (
            Modifier.fillMaxWidth().padding(bottom = 15.dp)
        ) {
            Box(Modifier.height(4.dp).weight(1f).clip(RoundedCornerShape(20.dp)).background(Color(0xFFC5AA73)))
            Spacer(Modifier.width(10.dp))
            Box(Modifier.height(4.dp).weight(1f).clip(RoundedCornerShape(100.dp)).background(Color(0xFFF9E0A9)))
        }

        CustomTextBox("Title")
        Spacer(Modifier.height(15.dp))
        CustomTextBox("Category")
        Spacer(Modifier.height(15.dp))
        CustomTextBox("Condition")
        Spacer(Modifier.height(15.dp))
        CustomTextBox("Quantity")
        Spacer(Modifier.height(15.dp))
        CustomTextBox("End Date/Time")
        Spacer(Modifier.height(15.dp))
    }
}

@Composable
fun CustomTextBox(text: String, type: String = ""){
    BasicText(
        text = text,
        modifier = Modifier
            .background(Color.Transparent)
            .border(
                width = 2.dp,
                color = Color(0xFFC5AA73),
                shape = RoundedCornerShape(17.5.dp)
            )
            .padding(vertical = 15.dp, horizontal = 16.dp)
            .fillMaxWidth(), // Add padding inside the border
        style = TextStyle(
            color = Color.White,
            fontSize = 16.sp // Adjust font size as needed
        )
    )
}