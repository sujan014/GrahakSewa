package com.example.grahaksewa.presentation.previewpage

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.grahaksewa.domain.model.Grahak
import com.example.grahaksewa.presentation.viewmodel.PreviewViewModel
import com.example.grahaksewa.util.Routes

@Composable
fun PreviewPage(
    previewVM: PreviewViewModel = hiltViewModel(),
    navController: NavController
){
    val grahak = previewVM.grahak
    if (grahak != null) {
        Box(
            modifier = Modifier
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp, vertical = 10.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Date: ${grahak.dateTime}",
                        modifier = Modifier.align(Alignment.CenterEnd)
                    )
                }
                Spacer(modifier = Modifier.height(25.dp))
                Text(text = "Name: ${grahak.firstName} ${grahak.middleName} ${grahak.lastName}",
                    fontSize = 20.sp,
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline
                    )
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Address: ${grahak.cityAddress}, ${grahak.localAddress}, ward no ${grahak.wardNo}")
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Maal: ${grahak.maal}")
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Tola: ${grahak.tola}")
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Quality: ${grahak.carat}")
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Details")
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "${grahak.description}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .border(width = 2.dp, shape = RectangleShape, color = Color.Black)
                        .padding(horizontal = 5.dp),
                    maxLines = 20,
                )
                Spacer(modifier = Modifier.height(5.dp))
                Box(
                    modifier = Modifier.fillMaxWidth(0.9f),
                ) {
                    Button(
                        modifier = Modifier.align(Alignment.TopStart),
                        onClick = {
                        navController.navigate(route = Routes.GRAHAK_LIST.route)
                    }) {
                        Text(
                            text = "Go to Home",
                            modifier = Modifier.padding(vertical = 10.dp, horizontal = 5.dp)
                        )
                    }
                    Button(
                        modifier = Modifier.align(Alignment.TopEnd),
                        onClick = {
                            navController.navigate(Routes.GRAHAK_ADD.withArgsId(id = grahak.id))
                        }
                    ) {
                        Text(
                            text = "Edit this",
                            modifier = Modifier.padding(vertical = 10.dp, horizontal = 5.dp)
                        )
                    }
                }
            }
        }
    }
}