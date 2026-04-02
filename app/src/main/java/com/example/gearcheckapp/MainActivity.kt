package com.gearcheckapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.gearcheckapp.ui.screens.GearCheckRoot
import com.gearcheckapp.ui.theme.GearCheckTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GearCheckTheme {
                GearCheckRoot()
            }
        }
    }
}