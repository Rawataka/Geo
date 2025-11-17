package com.example.geo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.compose.ui.platform.LocalContext
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
    var answered by remember { mutableStateOf(false) }
    var score by remember { mutableStateOf(0) }
    val context = LocalContext.current

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

        if (!answered) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Button(onClick = {
                    answered = true
                    if (currentQuestion.second == true) {
                        score++
                        Toast.makeText(context, "Верно", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Неверно", Toast.LENGTH_SHORT).show()
                    }
                }) {
                    Text("True")
                }
                Button(onClick = {
                    answered = true
                    if (currentQuestion.second == false) {
                        score++
                        Toast.makeText(context, "Верно", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Неверно", Toast.LENGTH_SHORT).show()
                    }
                }) {
                    Text("False")
                }
            }
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