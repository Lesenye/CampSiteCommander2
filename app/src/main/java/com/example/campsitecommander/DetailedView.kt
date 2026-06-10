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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.campsitecommander.ui.theme.CampSiteCommanderTheme

class DetailedView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //Declaring vairiables
        val itemName = intent.getStringExtra("ITEM_NAME") ?: ""
        val category = intent.getStringExtra("CATEGORY") ?: ""
        val quantity = intent.getStringExtra("QUANTITY") ?: ""
        @Composable
        fun GearItemRow(name: String, category: String, quantity: String, comment: String? = null) {
            Column {
                Text(text = "Item: $name", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Category: $category", style = MaterialTheme.typography.bodyMedium)
                Text(text = "Quantity: $quantity", style = MaterialTheme.typography.bodyMedium)
                if (comment != null) {
                    Text(text = "Comment: $comment", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.primary)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
        //This is the UI that the user will be able to add thier own items to the list
        setContent {
            CampSiteCommanderTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        // An icon that show the user that the current items they have added is thiers
                        Text(text = "Your Added Gear:", style = MaterialTheme.typography.headlineMedium)
                        
                        // Showing the items the user Added
                        GearItemRow(name = itemName, category = category, quantity = quantity , comment = "Great choice of Gear")//acknoledging the user of the great choice they picked
                        //reminding the user of other products or items they can pick up
                        Text(text = "Other Camping Items:", style = MaterialTheme.typography.headlineLarge)
                        GearItemRow(name = "Tent", category = "Shelter", quantity = "1", comment = "it is cold better not forget this :)")
                        GearItemRow(name = "Food", category = "Energy", quantity = "4", comment = "it is important to not forget your food :)")
                        GearItemRow(name = "Water Bottles", category = "Need", quantity = "5", comment = "don't forget the water bottles to stay hydrated")

                        //Adding a button to take the user back to the adding screen
                        Spacer(modifier = Modifier.width(20.dp))
                        ElevatedButton(
                            onClick = {
                                val intent = Intent(this@DetailedView,
                                    MainScreen::class.java
                                )
                                startActivity(intent)
                            }
                        ) {
                            Text("BACK")
                        }
                    }
                }
            }
        }
    }
}
