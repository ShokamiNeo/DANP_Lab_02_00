package com.danp.danp_lab_02_00.screens

import android.os.Message
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.danp.danp_lab_02_00.R

private val messages: List<MyMessage> = listOf(
    MyMessage("Lomo Saltado","Descripcion lomo"),
    MyMessage("Causa", "Con papa")
)

@Composable
fun SegundaVentana(navController: NavController, text: String?){
    Scaffold(topBar = {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow back",
                modifier = Modifier.clickable {
                    navController.popBackStack()
                })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "SegundaVentana")
        }
    }) {
        if(text == "Costa") {
            //ContenidoCosta(navController = navController, text = text, title = , body = )
            ListaCosta(navController, text, messages)
        } else if(text == "Sierra") {
            ContenidoSierra(navController, text)
        } else {
            ContenidoSelva(navController, text)
        }
        //SegundoContenido(navController, text)
    }
}

@Composable
fun ListaCosta(navController: NavController, text: String?, messages: List<MyMessage>) {
    LazyColumn {
        items(messages) { message->
            ContenidoCosta(navController = navController, text = text, message = message)
        }
    }
}
@Composable
fun ContenidoCosta(navController: NavController, text: String?, message: MyMessage) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.ic_lomo_saltado),
            contentDescription = "Lomo Saltado - Imagen Referencial",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = message.title,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(
                    text = message.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

data class MyMessage(val title: String, val body: String)

@Composable
fun ContenidoSierra(navController: NavController, text: String?) {

}

@Composable
fun ContenidoSelva(navController: NavController, text: String?) {

}

@Composable
fun SegundoContenido(navController: NavController, text: String?){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("He navegado")
        text?.let {
            Text(it)
        }
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text ("Volver")
        }
    }
}