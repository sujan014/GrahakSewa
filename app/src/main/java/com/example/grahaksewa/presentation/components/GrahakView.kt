package com.example.grahaksewa.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.grahaksewa.domain.model.Grahak
import com.example.grahaksewa.presentation.viewmodel.GrahakListViewModel
import com.example.grahaksewa.ui.theme.radiantblue

@Composable
fun GrahakView(
    grahak: Grahak,
    onDetails: () -> Unit,
    onDelete: () -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
            .background(color = Color.LightGray)
            .padding(vertical = 5.dp, horizontal = 5.dp),
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 2.dp, color = Color.Black, shape = RectangleShape)
                .padding(horizontal = 5.dp, vertical = 5.dp)
        ){
            Text(
                text = "${grahak.firstName} ${grahak.middleName} ${grahak.lastName}",
                fontWeight = FontWeight.ExtraBold
            )
            Text(text = "Maal: ${grahak.maal},")
            Text(text = "Tola: ${grahak.tola} , Carat: ${grahak.carat}")
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Button(
                    onClick = {
                        onDetails()
                    },
                    modifier = Modifier
                        .width(100.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = radiantblue,
                        contentColor = Color.Black
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "See details"
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
                Button(
                    onClick = {
                        onDelete()
                    },
                    modifier = Modifier
                        .width(100.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = radiantblue,
                        contentColor = Color.Black
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete"
                    )
                }
            }
        }
    }
}