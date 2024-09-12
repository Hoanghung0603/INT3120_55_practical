package com.example.composequadrant

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                QuadrantScreen()
            }
        }
    }
}

@Composable
fun QuadrantScreen() {
    Column (
        Modifier.fillMaxSize()
    ) {
        Row (
            Modifier.weight(1f)
        ) {
            Card(
                title = stringResource(R.string.title1),
                content = stringResource(R.string.content1),
                bgColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            Card(
                title = stringResource(R.string.title2),
                content = stringResource(R.string.content2),
                bgColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row (
            Modifier.weight(1f)
        ) {
            Card(
                title = stringResource(R.string.title3),
                content = stringResource(R.string.content3),
                bgColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            Card(
                title = stringResource(R.string.title4),
                content = stringResource(R.string.content4),
                bgColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun Card(
    title: String,
    content: String,
    bgColor: Color,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(bgColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() {
    ComposeQuadrantTheme {
        QuadrantScreen()
    }
}