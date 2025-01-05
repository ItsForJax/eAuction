package com.epds.dev.eauction.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// TODO: Fix the border issue iwth the dropdown


@Composable
fun AddAuction1() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        var selectedCategory by remember { mutableStateOf("Select an option") }
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
        CustomDropdownTextBox(
            text = "Category",
            items = listOf("Sample 1", "Sample 2", "Sample 3"),
            onItemSelected = {

            })
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


@Composable
fun CustomDropdownTextBox(
    text: String,
    items: List<String>,
    onItemSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(text) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .border(
                width = 2.dp,
                color = Color(0xFFC5AA73),
                shape = RoundedCornerShape(17.5.dp)
            )
            .clickable { expanded = true }
            .padding(vertical = 15.dp, horizontal = 16.dp)
    ) {
        Text(
            text = selectedText,
            style = TextStyle(
                color = Color.White,
                fontSize = 16.sp
            ),
            modifier = Modifier.fillMaxWidth()
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .padding(vertical = 15.dp, horizontal = 16.dp)
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = Color(0xFFC5AA73),
                    shape = RoundedCornerShape(17.5.dp)
                )
                .offset(y = 5.dp) // Adjust margin to match the dropdown menu
                .background(Color.Blue) // Make the background transparent
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    onClick = {
                        selectedText = item // Update the displayed text
                        expanded = false // Close the dropdown
                        onItemSelected(item) // Notify the parent of the selection
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Green)
                        .border(BorderStroke(1.dp, Color.White)),
                    text = {
                        Text(
                            text = item,
                            style = TextStyle(
                                color = Color.White, // Adjust dropdown item color to white
                                fontSize = 16.sp
                            ),
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
            )}
        }
    }
}


