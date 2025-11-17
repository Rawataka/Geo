package com.example.geo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.geo.ui.theme.GeoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GeoQuizApp()
                }
            }
        }
    }
}

@Composable
fun GeoQuizApp() {
    val questions = listOf(
        "Canberra is the capital of Australia." to true,
        "The Pacific Ocean is larger than the Atlantic Ocean." to true,
        "The Suez Canal connects the Red Sea and the Indian Ocean." to false,
        "The source of the Nile River is in Egypt." to false,
        "The Amazon River is the longest river in the Americas." to true,
        "Lake Baikal is the world's oldest and deepest freshwater lake." to true
    )

    var currentIndex by remember { mutableStateOf(0) }
    val currentQuestion = questions[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Question ${currentIndex + 1}/${questions.size}",
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            modifier = Modifier.padding(vertical = 20.dp)
        ) {
            Text(
                text = currentQuestion.first,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(24.dp)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GeoQuizPreview() {
    GeoTheme {
        GeoQuizApp()
    }
}