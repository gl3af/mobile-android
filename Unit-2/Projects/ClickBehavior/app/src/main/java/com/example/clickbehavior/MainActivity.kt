package com.example.clickbehavior

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clickbehavior.ui.theme.ClickBehaviorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClickBehaviorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        when (currentStep) {
            1 -> {
                Card(
                    text = R.string.lemon_select,
                    image = R.drawable.lemon_tree,
                    description = R.string.lemon_tree_content_description,
                    onImageClick = {
                        currentStep = 2
                        squeezeCount = (2..4).random()
                    }
                )
            }
            2 -> {
                Card(
                    text = R.string.lemon_squeeze,
                    image = R.drawable.lemon_squeeze,
                    description = R.string.lemon_content_description,
                    onImageClick = {
                        squeezeCount--
                        if (squeezeCount == 0) {
                            currentStep = 3
                        }
                    }
                )
            }

            3 -> {
                Card(
                    text = R.string.lemon_drink,
                    image = R.drawable.lemon_drink,
                    description = R.string.lemonade_content_description,
                    onImageClick = { currentStep = 4 }
                )
            }
            4 -> {
                Card(
                    text = R.string.lemon_empty_glass,
                    image = R.drawable.lemon_restart,
                    description = R.string.empty_glass_content_description,
                    onImageClick = { currentStep = 1 }
                )
            }
        }
    }
}

@Composable
fun Card(
    text: Int,
    image: Int,
    description: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier)
{
    Box(
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(onClick = onImageClick) {
                Image(
                    painter = painterResource(image),
                    contentDescription = stringResource(description),
                    modifier = Modifier
                        .width(128.dp)
                        .height(160.dp)
                        .padding(16.dp)
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ClickBehaviorPreview() {
    ClickBehaviorTheme {
        App()
    }
}