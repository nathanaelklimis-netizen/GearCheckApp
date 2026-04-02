package com.gearcheckapp.model

data class Checklist(
    val id: Int,
    val title: String,
    val description: String,
    val items: List<GearItem>
) {
    fun completionPercent(): Int {
        if (items.isEmpty()) return 0
        return (items.count { it.packed } * 100) / items.size
    }
}