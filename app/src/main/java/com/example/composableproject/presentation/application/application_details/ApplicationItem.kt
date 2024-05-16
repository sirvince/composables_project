package com.example.composableproject.presentation.application.application_details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composableproject.data.model.DataObject
import com.example.composableproject.ui.theme.PrimaryColor
import java.util.Locale

@Composable
fun ApplicationItem(application: DataObject) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {  },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),

    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

//            Row(
//                horizontalArrangement = Arrangement.Absolute.Center,
//                verticalAlignment = Alignment.CenterVertically,
//            ){
////                Text(
////                    text = application.formType.uppercase(Locale.ROOT),
////                    style = MaterialTheme.typography.titleLarge,
////                    color = Color.Black,
////                    fontWeight = FontWeight.Bold,
////                )
////                Column(
////                    modifier = Modifier
////                        .padding(16.dp)
//////                    .fillMaxWidth()
////                        .align(Alignment.CenterVertically)
////                ) {
////                    Text(
////                        text = application.referenceCode ?: "-",
////                        style = MaterialTheme.typography.titleLarge,
////                        color = PrimaryColor,
////                        fontWeight = FontWeight.Bold,
////                        lineHeight = 16.sp
////
////                    )
////
////                    Text(
////                        text = application.formGroup,
////                        style = MaterialTheme.typography.titleMedium,
////                        color = Color.Black,
////                        lineHeight = 16.sp
////
////                    )
////
////                    Text(
////                        text = application.getApplicationTypeAndProcessType(),
////                        style = MaterialTheme.typography.titleMedium,
////                        color = Color.Black,
////                        lineHeight = 16.sp
////                    )
////
////                    Text(
////                        text = application.getBrandProduct() ,
////                        style = MaterialTheme.typography.titleMedium,
////                        color = Color.Black,
////                        lineHeight = 16.sp
////
////                    )
////
////                    Text(
////                        text = application.getSubmissionDateTime() ,
////                        style = MaterialTheme.typography.titleMedium,
////                        color = Color.Black,
////                        lineHeight = 16.sp
////
////                    )
////
////
////
////                    Text(
////                        text = application.internalStatus,
////                        style = MaterialTheme.typography.titleMedium,
////                        color = Color.Black,
////                        lineHeight = 16.sp
////                    )
////
////                    Text(
////                        text = application.releaseStatus?: "-",
////                        style = MaterialTheme.typography.titleMedium,
////                        lineHeight = 16.sp,
////                        color = when(application.releaseStatus) {
////                            "INCOMPLETE" -> Color.Black
////                            "APPROVED FOR PRODUCTION","APPROVED WITH CAUTION","APPROVED" -> Color.Black
////                            "DISAPPROVED" -> Color.White
////                            else -> Color.Black
////                        },
////                        modifier = Modifier.background(
////                            color = when(application.releaseStatus) {
////                                "INCOMPLETE" -> Color.Yellow
////                                "APPROVED FOR PRODUCTION","APPROVED WITH CAUTION","APPROVED" -> Color.Green
////                                "DISAPPROVED" -> Color.Red
////                                else -> Color.White
////                            },
////                            shape = RoundedCornerShape(8.dp)
////                        ).padding(4.dp)
////                    )
////
////                }
//
//            }


            Column(
                modifier = Modifier
                    .padding(16.dp)
//                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = application.referenceCode ?: "-",
                    style = MaterialTheme.typography.titleLarge,
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 16.sp

                )

                Text(
                    text = application.getFormTypeGroup().uppercase(),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    lineHeight = 16.sp

                )

                Text(
                    text = application.getApplicationTypeAndProcessType(),
                    style = MaterialTheme.typography.titleMedium,

                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    lineHeight = 16.sp
                )

                Text(
                    text = application.getBrandProduct() ,
                    style = MaterialTheme.typography.titleMedium,

                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    lineHeight = 16.sp

                )

                Text(
                    text = application.getSubmissionDateTime() ,
                    style = MaterialTheme.typography.titleMedium,

                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    lineHeight = 16.sp

                )



                Text(
                    text = application.internalStatus,
                    style = MaterialTheme.typography.titleMedium,

                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    lineHeight = 16.sp
                )

                val applicationStatus = "APPROVED"
                Text(

                    text = applicationStatus?: "-",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 16.sp,
                    color = when(applicationStatus) {
                        "INCOMPLETE" -> Color.Black
                        "APPROVED FOR PRODUCTION","APPROVED WITH CAUTION","APPROVED" -> Color.Black
                        "DISAPPROVED" -> Color.White
                        else -> Color.Black
                    },
                    modifier = Modifier.background(
                        color = when(applicationStatus) {
                            "INCOMPLETE" -> Color.Yellow
                            "APPROVED FOR PRODUCTION","APPROVED WITH CAUTION","APPROVED" -> Color.Green
                            "DISAPPROVED" -> Color.Red
                            else -> Color.White
                        },
                        shape = RoundedCornerShape(8.dp)
                    ).padding(4.dp)
                )

            }

            Icon(
                painter = rememberVectorPainter(Icons.Default.KeyboardArrowRight),
                contentDescription = "user profile",
                tint = PrimaryColor,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}