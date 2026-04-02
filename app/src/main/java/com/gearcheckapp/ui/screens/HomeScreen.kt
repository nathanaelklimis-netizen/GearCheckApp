package com.gearcheckapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gearcheckapp.model.Checklist

@Composable
fun HomeScreen(
    checklists: List<Checklist>,
    onOpenChecklist: (Checklist) -> Unit,
    onCreateChecklist: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("GearCheck", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
        Text("Track readiness before departure")

        Button(
            onClick = onCreateChecklist,
            modifier = Modifier.padding(vertical = 12.dp)
        ) {
            Text("Create Checklist")
        }

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(checklists) { checklist ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onOpenChecklist(checklist) }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(checklist.title, fontWeight = FontWeight.Bold)
                        Text(checklist.description)
                        Text("Completion: ${checklist.completionPercent()}%")
                    }
                }
            }
        }
    }
}