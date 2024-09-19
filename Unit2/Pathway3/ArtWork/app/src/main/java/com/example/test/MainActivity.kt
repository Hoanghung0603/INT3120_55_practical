package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.ui.theme.TestTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTheme {
                ArtworkViewer()
            }
        }
    }
}

@Composable
fun ArtworkViewer() {
    val artworks = listOf(
        Pair("Perfect Lemon Tree", R.drawable.lemon_tree),
        Pair("A lemon", R.drawable.lemon_squeeze),
        Pair("Best Summer Drink!!", R.drawable.lemon_drink)
    )
    var currentIndex by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val currentImage: Painter = painterResource(id = artworks[currentIndex].second)
        Image(
            painter = currentImage,
            contentDescription = "Artwork Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = artworks[currentIndex].first,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Hoang Duy Hung (2021)",
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.wrapContentSize()
        ) {
            Button(onClick = {
                if (currentIndex > 0) {
                    currentIndex--
                }
            },
                modifier = Modifier.weight(0.7f)) {
                Text(text = "Previous")

            }

            Button(onClick = {
                if (currentIndex < artworks.size - 1) {
                    currentIndex++
                }
            },
                modifier = Modifier.weight(0.7f)) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtworkPreview() {
    TestTheme {
        ArtworkViewer()
    }
}