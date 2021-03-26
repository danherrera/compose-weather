/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.theme.MyTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
        ) {
            Column(Modifier.padding(horizontal = 16.dp)) {
                Text(text = "Now", style = MaterialTheme.typography.h3)
                Text(text = "Sandy Springs, GA", style = MaterialTheme.typography.caption)
                Text(text = "55°F", style = MaterialTheme.typography.h1)
                Text(text = "partly cloudy • 3% \uD83C\uDF27️", style = MaterialTheme.typography.body1)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "This Week", style = MaterialTheme.typography.h3)
            }
            LazyRow {
                items(
                    listOf(
                        WeatherDayForecast("WED", WeatherCondition.PARTLY_CLOUDY),
                        WeatherDayForecast("THU", WeatherCondition.SUNNY),
                        WeatherDayForecast("FRI", WeatherCondition.PARTLY_CLOUDY),
                        WeatherDayForecast("SAT", WeatherCondition.RAIN),
                        WeatherDayForecast("SUN", WeatherCondition.THUNDERSTORM),
                        WeatherDayForecast("MON", WeatherCondition.MOSTLY_CLOUDY),
                        WeatherDayForecast("TUE", WeatherCondition.MOSTLY_CLOUDY),
                    )
                ) {
                    Spacer(modifier = Modifier.width(8.dp))
                    SmallWeatherCard(weatherDayForecast = it)
                }
            }
        }
    }
}

data class WeatherDayForecast(
    val day: String,
    val condition: WeatherCondition,
)

@Composable
fun SmallWeatherCard(weatherDayForecast: WeatherDayForecast) {
    Card() {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = weatherDayForecast.day)
            Text(text = weatherDayForecast.condition.emoji, style = MaterialTheme.typography.h3)
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
