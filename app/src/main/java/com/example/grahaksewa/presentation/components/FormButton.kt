package com.example.grahaksewa.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grahaksewa.ui.theme.buttonEnabled
import com.example.grahaksewa.ui.theme.lightblue0
import com.example.grahaksewa.ui.theme.navy

@Composable
fun NewCustomText(content: String){
    Text(
        text = content,
        modifier = Modifier.padding(end = 10.dp),
        style = TextStyle(
            color = Color.White
        )
    );
}

@Composable
fun TextIconButton(
    text: String,
    icon: ImageVector,
    onButtonClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(color = lightblue0, shape = RoundedCornerShape(10.dp))
            .padding(horizontal = 5.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = text,
                style = TextStyle(
                    color = navy,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.W800,
                    //fontStyle = FontStyle.Italic,
                    //letterSpacing = 0.5.em,
                    //background = Color.LightGray,
                    textDecoration = TextDecoration.Underline
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            IconButton(
                onClick = {
                    onButtonClick()
                },
                modifier = Modifier.background(
                    color = buttonEnabled,
                    shape = RectangleShape
                )
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = text
                )
            }
        }
    }
}