package com.example.composableproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composableproject.ui.theme.ComposableProjectTheme

class BusinessCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(
                        "John Vincent Dallego",
                        "Assistant Secretary",
                        "09179677619",
                        "https://facebook/vince",
                        "johnvincentdallego@gmail.com"
                    )
                }
            }
        }
    }
}

//Business Card Information
@Composable
fun BusinessCard(
    name: String,
    position : String,
    contactNumber : String,
    facebookAccount : String,
    emailAddress : String,
    modifier: Modifier = Modifier
) {
    val companyLogo = painterResource(id = R.drawable.ic_logo)
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = companyLogo,
                    modifier = Modifier.size(150.dp),
                    contentDescription = "Philippines Eagles",
                    alignment = Alignment.Center
                )
                Text(
                    text = name,
                    fontSize = 32.sp,
                    lineHeight = 8.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = position,
                    lineHeight = 8.sp,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            contentAlignment = Alignment.Center
        ){
            Column {
                Row{
                    Icon(
                        imageVector = Icons.Default.Phone,
                        contentDescription = null)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = contactNumber,
                        textAlign = TextAlign.Center
                    )
                }

                Row{
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = null)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = facebookAccount,
                        textAlign = TextAlign.Center
                    )
                }


                Row{
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = emailAddress,
                        textAlign = TextAlign.Center
                    )
                }

            }
        }

    }



}

