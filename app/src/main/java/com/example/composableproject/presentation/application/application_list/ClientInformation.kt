package com.example.composableproject.presentation.application.application_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composableproject.ui.theme.ITEM_SPACING
import com.example.composableproject.ui.theme.PrimaryColor


@Composable
fun ClientInformation () {
    /*Client Information*/
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),

        ){

        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "Client Information",
                style = MaterialTheme.typography.titleLarge,
                color = PrimaryColor,
                fontWeight = FontWeight.Bold,
                lineHeight = 16.sp

            )

            Spacer(Modifier.height(ITEM_SPACING))

            val company = buildAnnotatedString {
                append("COMPANY: ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("DITO TELECOMMUNITY CORPORATION")
                }
            }

            Text(
                text = company,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                lineHeight = 16.sp

            )
            val affiliation = buildAnnotatedString {
                append("AFFILIATION: ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("NON-MEMBER ADVERTISER")
                }
            }

            Text(
                text = affiliation,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                lineHeight = 16.sp
            )

            val brand = buildAnnotatedString {
                append("BRAND: ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("DITO TELECOMMUNITY")
                }
            }


            Text(
                text = brand,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                lineHeight = 16.sp

            )

            val product = buildAnnotatedString {
                append("PRODUCT: ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("DITO APP")
                }
            }
            Text(
                text = product,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                lineHeight = 16.sp

            )


            val category = buildAnnotatedString {
                append("CATEGORY: ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("TELECOMMUNICATIONS")
                }
            }

            Text(
                text = category,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                lineHeight = 16.sp
            )

        }

    }
}