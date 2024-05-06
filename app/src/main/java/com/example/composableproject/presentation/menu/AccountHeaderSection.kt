package com.example.composableproject.presentation.menu


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composableproject.R
import com.example.composableproject.ui.theme.ITEM_SPACING
import com.example.composableproject.ui.theme.PrimaryColor
import com.example.composableproject.ui.theme.SecondaryColor

@Composable
fun AccountHeaderSection(
    account: Account,
){

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.Absolute.Center,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Icon(
                painter = painterResource(R.drawable.ic_user_profile),
                contentDescription = "user profile",
                modifier = Modifier.size(32.dp)
            )
            Spacer(Modifier.width(ITEM_SPACING))

            Column(
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = "Welcome back",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(Modifier.height(ITEM_SPACING))
                Text(
                    text = account.firstName,
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = account.role,
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_logout),
            contentDescription = "Search",
            tint = SecondaryColor ,
            modifier = Modifier.size(24.dp)
        )
    }

}


