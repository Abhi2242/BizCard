package com.smartgeek.bizcard

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smartgeek.bizcard.ui.theme.BizCardTheme
import com.smartgeek.bizcard.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardTheme {
                Surface {
                    CreateBizCard ()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard () {
    val buttonClickedState = remember { mutableStateOf(false) }
    Surface(modifier = Modifier.fillMaxSize(),color = Color.White) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(15.dp),
            shape = RoundedCornerShape(3),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(5.dp),
        ) {
            val context = LocalContext.current
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally) {
                CreateProfileImage()
                Divider(modifier = Modifier.fillMaxWidth(),
                    thickness = 1.5.dp)
                CreateInfo()
                Button(onClick = {
                    buttonClickedState.value = !buttonClickedState.value
                },
                    modifier = Modifier.padding(10.dp),
                    shape = RectangleShape) {
                    Text(text = "Portfolio")
                }
                if (buttonClickedState.value) {
                    Content()
                }
                else{
                    Box {}
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Content() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(),
            color = Color.White,
            shape = RoundedCornerShape(3),
            border = BorderStroke(width = 3.dp, color = Color.LightGray)
        ) {
            Portfolio(data = listOf("Project 1", "Project 2", "Project 3"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn(modifier = Modifier.background(Color.White)) {
        items(data) { item ->
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(),
                shape = RectangleShape,
                colors = CardDefaults.cardColors(Color.White),
                border = BorderStroke(width = 2.dp, color = Color.LightGray)
            ) {
                Row(modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .background(Color.White)){
                    CreateProfileImage(modifier = Modifier.size(100.dp))
                    Column(modifier = Modifier.fillMaxHeight()
                        .padding(5.dp)
                        .align(alignment = Alignment.CenterVertically)) {
                        Text(text = item,
                            color = Color.Black,
                            style = Typography.titleMedium)
                        Text(text = "A Great Project",
                            color = Color.Black,
                            style = Typography.bodySmall)
                    }
                }
            }
        }
    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Abhishek Vengurlekar",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Blue
        )
        Text(text = "Android Compose Programmer",
            color = Color.Black)
        Text(text = "__smartgeek2242",
            color = Color.Black)
    }
}

@Composable
private fun CreateProfileImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        tonalElevation = 5.dp,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 5.dp
    ) {
        Image(
            modifier = Modifier.size(120.dp),
            painter = painterResource(id = R.drawable.my_profile),
            contentDescription = "Profile Image"
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BizCardTheme {
        CreateBizCard ()
    }
}