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
fun MaterialInformation(){


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
                text = "Material Information",
                style = MaterialTheme.typography.titleLarge,
                color = PrimaryColor,
                fontWeight = FontWeight.Bold,
                lineHeight = 16.sp

            )

            Spacer(Modifier.height(ITEM_SPACING))

            val adTitle = buildAnnotatedString {
                append("AD TITLE: ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("AD TITLE DESCRIPTION")
                }
            }

            Text(
                text = adTitle,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                lineHeight = 16.sp

            )

            val previousRefCode = buildAnnotatedString {
                append("PREV.-APPROVED MATERIAL: ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,)) {
                    append("D001234567890D")
                }
            }

            Text(
                text = previousRefCode,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                lineHeight = 16.sp
            )

            val typeOfMedium = buildAnnotatedString {
                append("TYPE OF MEDIA: ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,)) {
                    append("MULTIMEDIA")
                }
            }
            Text(
                text = typeOfMedium,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                lineHeight = 16.sp

            )

            val medium = buildAnnotatedString {
                append("TYPE OF MEDIUM: ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,)) {
                    append("DIGITAL VIDEO")
                }
            }

            Text(
                text = medium ,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                lineHeight = 16.sp

            )

            val execution = buildAnnotatedString {
                append("EXECUTION: ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,)) {
                    append("SOCIAL MEDIA")
                }
            }



            Text(
                text = execution,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                lineHeight = 16.sp
            )


            val length = buildAnnotatedString {
                append("LENGTH / SIZE: ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,)) {
                    append("15")
                }
            }


            Text(
                text = length,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                lineHeight = 16.sp
            )


        }

    }

}