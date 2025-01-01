package com.epds.dev.eauction.screens

import com.epds.dev.eauction.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Homepage(){
    Column(
        Modifier
            .padding(horizontal = 24.dp)
            .padding(top = 18.dp)
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(painter = painterResource(
                id = R.drawable.spongebob),
                contentDescription = "profile picture",
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        brush = Brush.linearGradient( colors = listOf(Color(0xFFC5AA72), Color(0xFFFFCC5D))),
                        shape = CircleShape )
            )

            Column (
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp)
            ) {
                Text(
                    text = "Hello, Mr.Buyer",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color(0xFFC5AA73)
                )
                Text(
                    text = "Set Status",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }

            Image(painter = painterResource(
                id = R.drawable.globe),
                contentDescription = "profile picture",
                modifier = Modifier
                    .size(28.dp)
                    .clip(CircleShape)
            )
        }
        Spacer(Modifier.height(20.dp))
        SearchBox()
        Spacer(Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Your Auctions",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color(0xFFC5AA73)
            )
            Text(
                text = "View All",
                fontSize = 14.sp,
                color = Color.White
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 52.dp)
        ) {
            Text(
                text = "You have no auctions.",
                fontSize = 14.sp,
                color = Color.White
            )
            Text(
                text = "Click the “\uD83D\uDD28” to create one",
                fontSize = 14.sp,
                color = Color.White
            )
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Your Best Bid",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color(0xFFC5AA73)
            )
            DropdownFilter()
        }
        Spacer(Modifier.height(18.dp))
        ScrollableRowOfTexts()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 52.dp)
        ) {
            Text(
                text = "You have no auctions.",
                fontSize = 14.sp,
                color = Color.White
            )
            Text(
                text = "Click the “\uD83D\uDD28” to create one",
                fontSize = 14.sp,
                color = Color.White
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBox() {
    var searchQuery by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 2.dp,
                brush = Brush.linearGradient( colors = listOf(Color(0xFFC5AA72), Color(0xFFFFCC5D))),
                shape = RoundedCornerShape(17.5.dp)
            )
            .background(Color.Transparent)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 15.dp) // Adjust padding
        ) {
            Image(
                painter = painterResource(id = R.drawable.search_icon), // replace with your icon resource
                contentDescription = "Search Icon",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            BasicTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                decorationBox = { innerTextField ->
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(26.dp),
                        contentAlignment = Alignment.CenterStart // Center content vertically
                    ) {
                        if (searchQuery.isEmpty()) {
                            Text(
                                text = "Search",
                                color = Color(0xFF716E63),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W400
                            )
                        }
                        innerTextField()
                    }
                },
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownFilter() {
    var expanded by remember { mutableStateOf(false) }
    val options = listOf("Option 1", "Option 2", "Option 3")
    var selectedOption by remember { mutableStateOf(options[0]) }

    Box() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable { expanded = true } // Make the entire row clickable
        ) {
            Text(
                text = "Filter by: $selectedOption",
                color = Color.White,
            )
            Icon(
                painter = painterResource(id = R.drawable.drop_down_icon), // replace with your dropdown icon resource
                contentDescription = "Dropdown Icon",
                tint = Color.White,
                modifier = Modifier.size(14.dp, 16.dp)
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option, color = Color.Black) },
                    onClick = {
                        selectedOption = option
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun ScrollableRowOfTexts() {
    val texts = listOf("All", "Item 1", "Item 2", "Item 3")
    var selectedText by remember { mutableStateOf(texts[0]) }
    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(scrollState)
    ) {
        texts.forEach { text ->
            Box(
                modifier = Modifier
                    .clickable { selectedText = text }
                    .background(
                        color = if (selectedText == text) Color(0xFFC5AA73) else Color.Transparent,
                        shape = RoundedCornerShape(7.dp)
                    )
                    .padding(vertical = 2.dp, horizontal = 12.dp)
            ) {
                Text(
                    text = text,
                    color = if (selectedText == text) Color(0xFF201F1F) else Color.White,
                    fontSize = 16.sp,
                    fontWeight = if (selectedText == text) FontWeight.Bold else FontWeight.Normal,
                )
            }
        }
    }
}
