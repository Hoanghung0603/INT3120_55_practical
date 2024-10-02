package com.example.intentsandfilters

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import com.example.intentsandfilters.ui.theme.IntentsAndFiltersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("onCreate()")
        enableEdgeToEdge()
        setContent {
            IntentsAndFiltersTheme {
                ScreenView()
            }
        }
    }

}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ScreenView() {
    val (first, second, third, fourth) = remember { FocusRequester.createRefs() }
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row {
            TextButton(
                {},
                Modifier
                    .focusRequester(first)
                    .focusProperties { next = second }
            ) {
                Text("First field")
            }
            TextButton(
                {},
                Modifier
                    .focusRequester(third)
                    .focusProperties { next = fourth }
            ) {
                Text("Third field")
            }
        }

        Row {
            TextButton(
                {},
                Modifier
                    .focusRequester(second)
                    .focusProperties { next = third }
            ) {
                Text("Second field")
            }
            TextButton(
                {},
                Modifier
                    .focusRequester(fourth)
                    .focusProperties { next = first }
            ) {
                Text("Fourth field")
            }
        }
    }
}

@Preview
@Composable
fun previewScreen() {
    ScreenView()
}
