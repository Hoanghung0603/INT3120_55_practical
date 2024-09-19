package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeScreen()
            }
        }
    }
}

@Composable
fun LemonadeScreen() {
    var curState by remember { mutableStateOf(1) }
    var tapTimes by remember { mutableStateOf(0) }
    Surface(
        modifier = Modifier
            .background(Color(0xFFFFEB3B)),
    ) {
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(Color(0xFFFFEB3B)),
            contentAlignment = Alignment.Center

        ) {
            Text(
                text = "Lemonade",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        when (curState) {
            1 -> {
                LemonadeTextAndImage(
                    curTextResource = R.string.lemonTree,
                    curImgResource = R.drawable.lemon_tree,
                    contentDescriptResource = R.string.step1,
                    onImageClick = {
                        curState = 2
                        tapTimes = (3..5).random()
                    }
                )
            }

            2 -> {
                LemonadeTextAndImage(
                    curTextResource = R.string.lemon,
                    curImgResource = R.drawable.lemon_squeeze,
                    contentDescriptResource = R.string.step2,
                    onImageClick = {
                        tapTimes--
                        if (tapTimes == 0) {
                            curState = 3
                        }
                    }
                )
            }

            3 -> {
                LemonadeTextAndImage(
                    curTextResource = R.string.glass,
                    curImgResource = R.drawable.lemon_drink,
                    contentDescriptResource = R.string.step3,
                    onImageClick = {
                        curState = 4
                    }
                )
            }

            4 -> {
                LemonadeTextAndImage(
                    curTextResource = R.string.emptyGlass,
                    curImgResource = R.drawable.lemon_restart,
                    contentDescriptResource = R.string.step4,
                    onImageClick = {
                        curState = 1
                    }
                )
            }
        }
    }
}

@Composable
fun LemonadeTextAndImage(
    modifier: Modifier = Modifier,
    curTextResource: Int,
    curImgResource: Int,
    contentDescriptResource: Int,
    onImageClick: () -> Unit
) {
    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = onImageClick,
                shape = RoundedCornerShape(40.dp)
            ) {
                Image(
                    painter = painterResource(curImgResource),
                    contentDescription = stringResource(contentDescriptResource),

                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(curTextResource),
                fontSize = 18.sp,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview()
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        LemonadeScreen()
    }
}