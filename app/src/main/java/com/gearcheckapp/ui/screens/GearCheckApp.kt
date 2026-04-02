package com.gearcheckapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.gearcheckapp.data.GearRepository

sealed class Screen {
    data object Home : Screen()
    data class ChecklistDetail(val checklistId: Int) : Screen()
    data class AddItem(val checklistId: Int) : Screen()
}

@Composable
fun GearCheckRoot() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }

    when (val screen = currentScreen) {
        is Screen.Home -> HomeScreen(
            checklists = GearRepository.checklists,
            onOpenChecklist = { currentScreen = Screen.ChecklistDetail(it.id) },
            onCreateChecklist = {
                GearRepository.addChecklist("New Checklist", "Custom checklist")
            }
        )

        is Screen.ChecklistDetail -> {
            val checklist = GearRepository.checklists.first { it.id == screen.checklistId }

            ChecklistScreen(
                checklist = checklist,
                onBack = { currentScreen = Screen.Home },
                onAddItem = { currentScreen = Screen.AddItem(screen.checklistId) },
                onToggleItem = { itemId -> GearRepository.toggleItem(screen.checklistId, itemId) },
                onReset = { GearRepository.resetChecklist(screen.checklistId) }
            )
        }

        is Screen.AddItem -> AddItemScreen(
            onSave = { name, category, required ->
                GearRepository.addItem(screen.checklistId, name, category, required)
                currentScreen = Screen.ChecklistDetail(screen.checklistId)
            },
            onBack = { currentScreen = Screen.ChecklistDetail(screen.checklistId) }
        )
    }
}