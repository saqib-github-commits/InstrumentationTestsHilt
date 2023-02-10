package com.example.instrumentedtesthilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.instrumentedtesthilt.composables.ArticlesScreen
import com.example.instrumentedtesthilt.ui.theme.InstrumentationTestsHiltTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstrumentationTestsHiltTheme {
                ArticlesScreen(hiltViewModel())
            }
        }
    }
}