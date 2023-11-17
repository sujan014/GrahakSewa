package com.example.grahaksewa.presentation.mainpage

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.grahaksewa.domain.model.Grahak
import com.example.grahaksewa.presentation.components.GrahakView
import com.example.grahaksewa.presentation.viewmodel.GrahakListViewModel
import com.example.grahaksewa.ui.theme.inkblack
import com.example.grahaksewa.ui.theme.radiantblue
import com.example.grahaksewa.util.Routes
import com.example.grahaksewa.util.grahakLog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GrahakMain(
    viewModel: GrahakListViewModel = hiltViewModel(),
    navController: NavController
){
    var grahakList: State<List<Grahak>> = viewModel.grahakList.collectAsState(initial = emptyList())
    val searchText by viewModel.searchText.collectAsState()

    Log.d("All Grahak List", "$grahakList")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = inkblack)
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 10.dp,),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = searchText,
                onValueChange = viewModel::onSearchTextChange,
                trailingIcon = {
                    IconButton(onClick = {  }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                    }
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier
                    .weight(1f),
            ) {
                // search box
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    items(grahakList.value) {
                        GrahakView(
                            grahak = it,
                            onDelete = {
                                viewModel.onDelete(it)
                            },
                            onDetails = {
                                navController.navigate(route = Routes.GRAHAK_PREVIEW.withArgsId(it.id))
                            }
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
            Button(
                modifier = Modifier
                    .padding(vertical = 5.dp),
                onClick = {
                    navController.navigate(route = Routes.GRAHAK_ADD.route)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = radiantblue,
                    contentColor = Color.Black
                ),
                contentPadding = PaddingValues.Absolute(left= 40.dp, top=10.dp, right = 40.dp, bottom=10.dp)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Add grahak",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}
