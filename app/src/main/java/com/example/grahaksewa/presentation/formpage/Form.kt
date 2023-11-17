package com.example.grahaksewa.presentation.formpage

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberScrollableState
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.grahaksewa.presentation.components.NewCustomText
import com.example.grahaksewa.presentation.components.TextIconButton
import com.example.grahaksewa.presentation.viewmodel.FormViewModel
import com.example.grahaksewa.ui.theme.inkblack
import com.example.grahaksewa.util.FormUIEvent
import com.example.grahaksewa.util.Routes
import kotlinx.coroutines.flow.collect

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Form(
    formVM: FormViewModel = hiltViewModel(),
    navController: NavController
){
    val scrollState = rememberScrollState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = true){
        formVM.formUIEvent.collect{ event ->
            when(event){
                is FormUIEvent.FormMessage -> {
                    snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = inkblack)
        )
        {
            Column(
                modifier = Modifier
                    .padding(vertical = 20.dp, horizontal = 20.dp)
                    .verticalScroll(scrollState)
            ) {
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    NewCustomText("First name");
                    TextField(
                        value = formVM.firstName,
                        onValueChange = {
                            formVM.firstName = it
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 10.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Ascii
                        )
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    NewCustomText("Middle name");
                    TextField(
                        value = formVM.middleName,
                        onValueChange = {
                            formVM.middleName = it
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 10.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Ascii
                        )
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    NewCustomText("Last name");
                    TextField(
                        value = formVM.lastName,
                        onValueChange = {
                            formVM.lastName = it
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 10.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Ascii
                        )
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Divider(
                    color = Color.Red,
                    modifier = Modifier
                        .fillMaxWidth()  //fill the max height
                        .width(2.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    NewCustomText("Date");
                    TextField(
                        value = formVM.dateTime,
                        onValueChange = {
                            formVM.dateTime = it
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 10.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Ascii
                        )
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    NewCustomText("City address");
                    TextField(
                        value = formVM.cityAddress,
                        onValueChange = {
                            formVM.cityAddress = it
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 10.dp)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    NewCustomText("Local address")
                    TextField(
                        value = formVM.localAddress,
                        onValueChange = {
                            formVM.localAddress = it
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 10.dp)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    NewCustomText("Ward no");
                    TextField(
                        value = formVM.wardNo,
                        onValueChange = {
                            formVM.wardNo = it
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 10.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        )
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Divider(
                    color = Color.Red,
                    modifier = Modifier
                        .fillMaxWidth()  //fill the max height
                        .width(2.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    NewCustomText("Maal");
                    TextField(
                        value = formVM.maal,
                        onValueChange = {
                            formVM.maal = it
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 10.dp)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        NewCustomText("Tola");
                        TextField(
                            value = formVM.tola,
                            onValueChange = {
                                formVM.tola = it
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 10.dp),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            )
                        )
                    }
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        NewCustomText("Carat");
                        TextField(
                            value = formVM.carat,
                            onValueChange = {
                                formVM.carat = it
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 10.dp),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                NewCustomText("Description")
                TextField(
                    value = formVM.description,
                    onValueChange = {
                        formVM.description = it
                    },
                    maxLines = 10,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Divider(
                    color = Color.Red,
                    modifier = Modifier
                        .fillMaxWidth()  //fill the max height
                        .width(2.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    TextIconButton(
                        text = "Go Home",
                        icon = Icons.Default.Home,
                        onButtonClick = { navController.navigate(Routes.GRAHAK_LIST.route) }
                    )
                    /*Box(
                    modifier = Modifier
                        .background(color = lightblue0, shape = RoundedCornerShape(10.dp))
                        .padding(horizontal = 5.dp, vertical = 10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    TextIconButton(
                        text = "Go Home",
                        icon = Icons.Default.Home,
                        onButtonClick = { navController.navigate(Routes.GRAHAK_LIST.route) }
                    )
                }*/
                    Spacer(
                        modifier = Modifier
                            .width(10.dp)
                            .weight(1f)
                    )
                    TextIconButton(
                        text = "Add to list",
                        icon = Icons.Default.Add,
                        onButtonClick = {
                            formVM.onAddNewEvent()
                        }
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Spacer(
                        modifier = Modifier
                            .width(10.dp)
                            .weight(1f)
                    )
                    TextIconButton(
                        text = "Preview",
                        icon = Icons.Default.Info,
                        onButtonClick = {
                            if (formVM.currentId != null) {
                                navController.navigate(
                                    route = Routes.GRAHAK_PREVIEW.withArgsId(
                                        formVM.currentId
                                    )
                                )
                            }
                        }
                    )
                    Spacer(
                        modifier = Modifier
                            .width(10.dp)
                            .weight(1f)
                    )
                    TextIconButton(
                        text = "Delete",
                        icon = Icons.Default.Delete,
                        onButtonClick = {
                            formVM.onDeleteEvent()
                        }
                    )
                }
            }
        }
    }
}