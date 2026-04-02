package com.gearcheckapp.model

data class GearItem(
    val id: Int,
    val name: String,
    val category: String,
    val required: Boolean,
    val packed: Boolean = false
)