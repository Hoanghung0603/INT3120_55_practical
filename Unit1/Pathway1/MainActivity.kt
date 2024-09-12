package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface (
                    modifier = Modifier.fillMaxSize()
                ){
                    CardInfo()
                }
            }
        }
    }
}

@Composable
fun CardInfo(modifier: Modifier = Modifier) {
    Image (
        painter = painterResource(R.drawable.businessbg),
        contentDescription = null
    )
    Column (
        modifier = Modifier.padding(start = 20.dp, top = 380.dp)
    ) {
        Text(
            text = stringResource(R.string.name),
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 20.dp)
        )
        Text (
            text = stringResource(R.string.phoneInfo),
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text (
            text = stringResource(R.string.email),
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text (
            text = stringResource(R.string.AcademicState),
            color = Color.White,
            fontSize = 18.sp,
        )
        
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        CardInfo()
    }
}