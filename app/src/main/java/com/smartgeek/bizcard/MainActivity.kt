package com.smartgeek.bizcard

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smartgeek.bizcard.ui.theme.BizCardTheme

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
                    println(
                        Toast.makeText(
                            context,
                            "Button Clicked",
                            Toast.LENGTH_LONG
                        ).show()
                    )
                },
                    modifier = Modifier.padding(10.dp),
                    shape = RectangleShape) {
                    Text(text = "Portfolio")
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
private fun CreateProfileImage() {
    Surface(
        modifier = Modifier
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BizCardTheme {
        CreateBizCard ()
    }
}