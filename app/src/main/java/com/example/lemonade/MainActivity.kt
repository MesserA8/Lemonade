package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeInteractive(modifier: Modifier = Modifier) {
    val images = listOf(
        R.drawable.lemon_tree,
        R.drawable.lemon_squeeze,
        R.drawable.lemon_drink,
        R.drawable.lemon_restart
    )
    val description = listOf(
        R.string.lemon_tree_description,
        R.string.squeeze_description,
        R.string.lemon_drink_description,
        R.string.lemon_restart_description
    )
    val imageText = listOf(
        R.string.tap_tree,
        R.string.squeeze_lemon,
        R.string.tap_to_drink,
        R.string.start_again_tap
    )
    var currentIndex by remember { mutableStateOf(0) }
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(images[currentIndex]),
            contentDescription = stringResource(description[currentIndex]),
            modifier = Modifier
                .clickable {
                    currentIndex = (currentIndex + 1) % images.size
                }
                .background(
                    color = Color.Cyan,
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(20.dp)
                .size(200.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(imageText[currentIndex]),
            fontSize = 18.sp
            )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LemonadeApp() {
    LemonadeTheme {
        LemonadeInteractive(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }
}