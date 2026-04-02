package com.gearcheckapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gearcheckapp.model.Checklist
import com.gearcheckapp.ui.components.GearItemCard

@Composable
fun ChecklistScreen(
    checklist: Checklist,
    onBack: () -> Unit,
    onAddItem: () -> Unit,
    onToggleItem: (Int) -> Unit,
    onReset: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(checklist.title, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
        Text(checklist.description)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Progress: ${checklist.completionPercent()}%")
        Spacer(modifier = Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = onBack) { Text("Back") }
            Button(onClick = onAddItem) { Text("Add Item") }
            Button(onClick = onReset) { Text("Reset") }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            items(checklist.items) { item ->
                GearItemCard(item = item, onToggle = { onToggleItem(item.id) })
            }
        }
    }
}