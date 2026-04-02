package com.gearcheckapp.data

import androidx.compose.runtime.mutableStateListOf
import com.gearcheckapp.model.Checklist
import com.gearcheckapp.model.GearItem

object GearRepository {
    val checklists = mutableStateListOf(
        Checklist(
            id = 1,
            title = "Deployment Bag",
            description = "Core readiness items before departure",
            items = listOf(
                GearItem(1, "ID Card", "Admin", true),
                GearItem(2, "Uniform", "Clothing", true),
                GearItem(3, "Boots", "Clothing", true),
                GearItem(4, "Phone Charger", "Electronics", true),
                GearItem(5, "Water Bottle", "Sustainment", false)
            )
        ),
        Checklist(
            id = 2,
            title = "Gym Bag",
            description = "Standard workout preparation checklist",
            items = listOf(
                GearItem(1, "Shoes", "Training", true),
                GearItem(2, "Towel", "Training", false),
                GearItem(3, "Protein Shake", "Nutrition", false)
            )
        )
    )

    fun addChecklist(title: String, description: String) {
        checklists.add(
            Checklist(
                id = checklists.size + 1,
                title = title,
                description = description,
                items = emptyList()
            )
        )
    }

    fun addItem(checklistId: Int, name: String, category: String, required: Boolean) {
        val index = checklists.indexOfFirst { it.id == checklistId }
        if (index == -1) return

        val checklist = checklists[index]
        val updatedItems = checklist.items + GearItem(
            id = checklist.items.size + 1,
            name = name,
            category = category,
            required = required
        )

        checklists[index] = checklist.copy(items = updatedItems)
    }

    fun toggleItem(checklistId: Int, itemId: Int) {
        val index = checklists.indexOfFirst { it.id == checklistId }
        if (index == -1) return

        val checklist = checklists[index]
        val updatedItems = checklist.items.map {
            if (it.id == itemId) it.copy(packed = !it.packed) else it
        }

        checklists[index] = checklist.copy(items = updatedItems)
    }

    fun resetChecklist(checklistId: Int) {
        val index = checklists.indexOfFirst { it.id == checklistId }
        if (index == -1) return

        val checklist = checklists[index]
        val updatedItems = checklist.items.map { it.copy(packed = false) }
        checklists[index] = checklist.copy(items = updatedItems)
    }
}