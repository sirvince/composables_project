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
import com.example.composableproject.data.model.DataObject
import com.example.composableproject.ui.theme.ITEM_SPACING
import com.example.composableproject.ui.theme.PrimaryColor


@Composable
fun ApplicantInformation (
    application : DataObject
) {
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
                text = "Applicant Information",
                style = MaterialTheme.typography.titleLarge,
                color = PrimaryColor,
                fontWeight = FontWeight.Bold,
                lineHeight = 16.sp

            )

            Spacer(Modifier.height(ITEM_SPACING))
            val name = buildAnnotatedString {
                append("NAME: ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                     append(application.applicant?.getFullName())
                }
            }

            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                lineHeight = 16.sp

            )


            val company = buildAnnotatedString {
                append("COMPANY: ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(application.applicant?.company?.name)
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
                    append(application.applicant?.company?.affiliate?.name)
                }
            }

            Text(
                text = affiliation,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                lineHeight = 16.sp
            )

            val phoneNumber = buildAnnotatedString {
                append("MOBILE NO: ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(application.applicant?.phone)
                }
            }


            Text(
                text = phoneNumber,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                lineHeight = 16.sp

            )

            val email = buildAnnotatedString {
                append("EMAIL: ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(application.applicant?.email)

                }
            }
            Text(
                text = email,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                lineHeight = 16.sp

            )

        }

    }
}