package com.example.composableproject.presentation.application.application_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
fun DocumentHistory(){
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
                text = "Document History",
                style = MaterialTheme.typography.titleLarge,
                color = PrimaryColor,
                fontWeight = FontWeight.Bold,
                lineHeight = 16.sp

            )

            Spacer(Modifier.height(ITEM_SPACING))
            val linksList = List(3) { index -> "LINK $index" }
            linksList.forEach { link ->

                    val formType = buildAnnotatedString {
                        append("FORM TYPE: ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,)) {
                            append("S2 ORIGINAL")
                        }
                    }

                    Text(
                        text = formType,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Black,
                        lineHeight = 16.sp
                    )


                    val decisionStatus = buildAnnotatedString {
                        append("DECISION STATUS: ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,)) {
                            append("APPROVED")
                        }
                    }

                    Text(
                        text = decisionStatus,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Black,
                        lineHeight = 16.sp
                    )



                    LazyRow {
                    items(10) { image ->
                        Text(
                            text = "LINK",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Black,
                            lineHeight = 16.sp,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
                }
            }

        }

}