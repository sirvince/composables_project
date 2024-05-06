package com.example.composableproject.presentation.member

import android.util.Log
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.composableproject.R
import com.example.composableproject.ui.theme.PrimaryColor
import com.example.composableproject.ui.theme.SecondaryColor
import com.example.composableproject.ui.theme.TertiaryColor

@Composable
fun PuppyListItem(member: Member) {
    Log.v("PuppyListItem", member.firstName)
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {  },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = SecondaryColor,
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
                Icon(
                    painter = painterResource(R.drawable.ic_user_profile),
                    contentDescription = "user profile",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(16.dp)
//                    .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = member.getFullName(),
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                    )
                    member.position?.let {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White
                        )
                    }
                    Text(
                        text = if (member.isActive == true) "Active" else "Deactivate",
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.White,
                    )

                }

            }

            Icon(
                painter = rememberVectorPainter(Icons.Default.Info),
                contentDescription = "user profile",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}