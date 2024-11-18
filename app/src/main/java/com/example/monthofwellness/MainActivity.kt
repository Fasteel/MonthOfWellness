package com.example.monthofwellness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.monthofwellness.ui.theme.MonthOfWellnessTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MonthOfWellnessTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(title = {
                            Text(text = stringResource(R.string.top_bar_title))
                        })
                    }
                ) { paddingValues ->
                    HomeScreen(modifier = Modifier.padding(paddingValues))
                }
            }
        }
    }
}
