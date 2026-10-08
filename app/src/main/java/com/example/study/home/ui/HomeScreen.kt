package com.example.study.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(innerPadding: PaddingValues) {
    val viewModel: HomeViewModel = viewModel()
//    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
//        Text("Hola mundo", modifier = Modifier.padding(innerPadding))
//        Button(onClick = { viewModel.getAllCharacters() }) {
//            Text("get Characters")
//        }
//    }
    TimerList(viewModel)

}

@Composable
fun TimerList(viewModel: HomeViewModel){
    val items by viewModel.items.collectAsState()
    val currentTime by viewModel.currentTime.collectAsState()

    LazyColumn(Modifier.fillMaxSize()) {
        items(items){ item ->
            LaunchedEffect(item.id) {
                viewModel.startTimeForItem(item.id)
            }

            val elapsedTime = if(item.startTime != null){
                (currentTime - item.startTime) / 1000
            } else {
                0L
            }

            Row(modifier = Modifier.padding(16.dp)) {
                Text(text = item.title)
                Spacer(Modifier.weight(1f))
                Text(text = "Time: $elapsedTime s")
            }
        }
    }
}