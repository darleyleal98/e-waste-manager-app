package com.darleyleal.e_wastemanager

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darleyleal.e_wastemanager.ui.theme.EWasteManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EWasteManagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// DARLEY LEAL RU 4102341

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.run {
                    verticalGradient(
                        colors = listOf(
                            Color(0xFF000000), Color(0xFF11D763)
                        )
                    )
                }
            ),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier
                .padding(top = 64.dp)
                .size(50.dp),
            tint = Color.White,
            painter = painterResource(R.drawable.baseline_recycling_24),
            contentDescription = stringResource(R.string.logo_app)
        )
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = "e-Waste",
            color = Color.White,
            fontSize = 33.sp
        )
        Text(
            modifier = Modifier.padding(start = 60.dp),
            text = "Manager", color = Color.White
        )

        var email by remember { mutableStateOf("") }
        var senha by remember { mutableStateOf("") }

        TextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text("Digite o seu e-mail")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp, start = 16.dp, end = 16.dp)
        )
        TextField(
            value = senha,
            onValueChange = {
                senha = it
            },
            label = {
                Text(text = "Digite a sua senha")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        )
        Button(
            onClick = {},
            modifier = Modifier.padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF4E342E))
        ) {
            Text(text = "ENTRAR")
        }
        Text(
            text = "Ainda não é cadastrado? Cadastre-se!",
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}