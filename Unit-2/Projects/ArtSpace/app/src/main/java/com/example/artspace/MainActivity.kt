package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
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
    val images =
        intArrayOf(R.drawable.losyash, R.drawable.krosh, R.drawable.barash, R.drawable.yozhik)
    val names = intArrayOf(R.string.losyash, R.string.krosh, R.string.barash, R.string.yozhik)
    val infos = intArrayOf(
        R.string.losyash_info,
        R.string.krosh_info,
        R.string.barash_info,
        R.string.yozhik_info
    )

    var index by remember { mutableStateOf(0) }

    when (index) {
        0 -> {
            Card(
                image = images[index],
                name = names[index],
                info = infos[index],
                onPrevClick = {index = 3},
                onNextClick = {index = 1}
            )
        }
        1 -> {
            Card(
                image = images[index],
                name = names[index],
                info = infos[index],
                onPrevClick = {index = 0},
                onNextClick = {index = 2}
            )
        }
        2 -> {
            Card(
                image = images[index],
                name = names[index],
                info = infos[index],
                onPrevClick = {index = 1},
                onNextClick = {index = 3}
            )
        }
        else -> {
            Card(
                image = images[index],
                name = names[index],
                info = infos[index],
                onPrevClick = {index = 2},
                onNextClick = {index = 0}
            )
        }
    }
}

@Composable
fun Card(
    @DrawableRes image: Int,
    @StringRes name: Int,
    @StringRes info: Int,
    onPrevClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = modifier.size(16.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(name),
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )
            Text(
                text = stringResource(info),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
            )
        }
        Spacer(modifier = modifier.size(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = onPrevClick,
                modifier = modifier.padding(end = 16.dp)
            ) {
                Text(
                    text = "Prev",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
            Button(
                onClick = onNextClick,
                modifier = modifier.padding(end = 16.dp)
            ) {
                Text(
                    text = "Next",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        App()
    }
}