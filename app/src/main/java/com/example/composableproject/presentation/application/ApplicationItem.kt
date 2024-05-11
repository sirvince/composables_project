package com.example.composableproject.presentation.application

import android.util.Log
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
import com.example.composableproject.ui.theme.PrimaryColor
import com.example.composableproject.ui.theme.Purple40
import com.example.composableproject.ui.theme.S1Color
import com.example.composableproject.ui.theme.S2Color
import com.example.composableproject.ui.theme.SecondaryColor
import com.example.composableproject.ui.theme.TertiaryColor

@Composable
fun ApplicationItem(application: Application) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {  },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = if (application.formType == "S1") {
                PrimaryColor
            } else {
                TertiaryColor
            }
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

            Row(
                horizontalArrangement = Arrangement.Absolute.Center,
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    text = application.formType,
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
                Column(
                    modifier = Modifier
                        .padding(16.dp)
//                    .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = application.referenceCode ?: "-",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                    )

                    Text(
                        text = application.applicationType,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                    )

                    Text(
                        text = application.getBrandProduct() ,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                    )

//                    Text(
//                        text = application.product,
//                        style = MaterialTheme.typography.titleMedium,
//                        color = Color.White,
//                    )

                    Text(
                        text = application.internalStatus,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                    )

                    Text(
                        text = application.releaseStatus?: "-",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                    )

                }

            }

            Icon(
                painter = rememberVectorPainter(Icons.Default.KeyboardArrowRight),
                contentDescription = "user profile",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}