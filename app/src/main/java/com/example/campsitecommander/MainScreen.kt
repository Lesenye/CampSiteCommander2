package com.example.campsitecommander

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.campsitecommander.ui.theme.CampSiteCommanderTheme

class MainScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampSiteCommanderTheme {
                Column(
                    //(fill.MaxSize) is used to fill the whole screen
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    //Declaring variables
                    var ItemName by remember { mutableStateOf("") }
                    var Category by remember { mutableStateOf("") }
                    var Quantity by remember { mutableStateOf("") }

                    //prompting user to enter information
                    Spacer(modifier = Modifier.height(20.dp))
                    Text("Please enter item you need to pick up")

                    //Item names
                    OutlinedTextField(
                        value = ItemName,
                        onValueChange = { ItemName = it },
                        label = { Text("Item Name") },
                        placeholder = { Text("Item Name") }
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text("Please enter Category")

                    //Categories
                    OutlinedTextField(
                        value = Category,
                        onValueChange = { Category = it },
                        label = { Text("Enter Category") },
                        placeholder = { Text("Enter Category") }
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text("Please enter Quantity")

                    //Quantity
                    OutlinedTextField(
                        value = Quantity,
                        onValueChange = { Quantity = it },
                        label = { Text("Quantity") },
                        placeholder = { Text("Quantity") }
                    )

                    //Button to add items
                    Spacer(modifier = Modifier.height(20.dp))
                    Row() {
                        ElevatedButton(
                            onClick = {
                                val intent = Intent(this@MainScreen, DetailedView::class.java).apply {
                                    putExtra("ITEM_NAME", ItemName)
                                    putExtra("CATEGORY", Category)
                                    putExtra("QUANTITY", Quantity)
                                }
                                startActivity(intent)
                            }
                        ) {
                            Text("ADD GEAR")
                        }

                        //Button to reset items the user has added by mistake
                        Spacer(modifier = Modifier.width(20.dp))
                        ElevatedButton(
                            onClick = {
                                ItemName = ""
                                Category = ""
                                Quantity = ""
                            }
                        ){
                            Text("RESET")
                        }
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    ElevatedButton(
                        onClick = {
                            finishAffinity()//This code will close the app once user presses exit
                        }
                    ) {
                        Text("EXIT")
                    }
                }
            }
        }
    }
}