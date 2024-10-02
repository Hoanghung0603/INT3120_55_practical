package com.example.intentsandfilters

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.intentsandfilters.ui.theme.IntentsAndFiltersTheme

class SecondActivity:  ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column (
                modifier = Modifier.fillMaxSize().padding(50.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ){
                IntentsAndFiltersTheme {
                    Text(text = "Second Activity")

                    Button(onClick = {
                        val intent = Intent(applicationContext, ThirdActivity::class.java)
                        startActivity(intent)
                    }) {

                        Text(text = "Activity2")

                    }

                }
            }

        }
    }
}