package com.example.campsitecommander

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.campsitecommander.ui.theme.CampSiteCommanderTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampSiteCommanderTheme {

                // Adding the splash screen when app is opened up
                LaunchedEffect(Unit) {
                    delay(3000) //The 3000 is 3 seconds
                    val intent = Intent(this@MainActivity, MainScreen::class.java)
                    startActivity(intent)
                    finish()
                }
                //Now placing the apps logo which is Campsite Commander in the middle for a nicer UI
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "CAMPSITE COMMANDER",
                        fontSize = 15.sp,
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
        }
    }
}

