package com.example.composableproject.presentation.member_profile

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composableproject.R
import com.example.composableproject.component.InputTextField
import com.example.composableproject.presentation.login.LoginFormEvent
import com.example.composableproject.presentation.member.SampleData
import com.example.composableproject.ui.theme.PrimaryColor
import com.example.composableproject.ui.theme.SecondaryColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemberProfile(
    navController: NavController
){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = topAppBarColors(
                    containerColor = PrimaryColor,
                    titleContentColor = Color.White,
                ),
                title = {
                    Text(
                        "Profile",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description",
                            tint = Color.White
                        )
                    }
                },

//                scrollBehavior = scrollBehavior,
            )
        }
    ) { innerPadding ->
        ScrollContent(innerPadding)

    }
}

@Composable
fun ScrollContent(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier.padding(innerPadding),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {

        Box(
            modifier = Modifier
                .background(PrimaryColor)
                .padding(8.dp)
                .fillMaxWidth(),
        ){
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ){
                Image(
                    painter = painterResource(id = R.drawable.ic_logo),
                    modifier = Modifier.size(150.dp),
                    contentDescription = "LOGO"
                )
                Text(
                    text = "John Vincent Dallego",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = "Instructor",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White,
                )

                Text(
                    text = "Member",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                )

                Row(
                    modifier = Modifier.padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Button(
                        modifier = Modifier.padding(8.dp),
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White, // Background color for Button 3
                            contentColor = PrimaryColor
                        ),

                        ) {
                        Icon(Icons.Filled.Phone, contentDescription = "Home")
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Call")
                    }

                    Button(
                        modifier = Modifier.padding(8.dp),
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White, // Background color for Button 3
                            contentColor = PrimaryColor
                        ),

                        ) {
                        Icon(Icons.Filled.Email, contentDescription = "Home")
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "E-Mail")
                    }

                    Button(
                        modifier = Modifier.padding(8.dp),
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White, // Background color for Button 3
                            contentColor = PrimaryColor
                        ),

                    ) {
                        Icon(Icons.Filled.KeyboardArrowRight, contentDescription = "Home")
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "More")
                    }
                }
            }
        }
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable { },
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            ){
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ){

//                Text(
//                    text = "Personal Information",
//                    style = MaterialTheme.typography.titleLarge,
//                    color = Color.Black,
//                    fontWeight = FontWeight.Bold,
//                )

                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),

                ) {


                    Row(
                        horizontalArrangement = Arrangement.spacedBy(32.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Icon(
                            painter = rememberVectorPainter(Icons.Default.Email),
                            contentDescription = "email",
                            tint = PrimaryColor,
                            modifier = Modifier.size(24.dp)
                        )

                        Text(
                            text = "johnvincent@gmail.com",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Black,
                        )
                    }


                    Row(
                        horizontalArrangement = Arrangement.spacedBy(32.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Icon(
                            painter = rememberVectorPainter(Icons.Default.Phone),
                            contentDescription = "email",
                            tint = PrimaryColor,
                            modifier = Modifier.size(24.dp)
                        )

                        Text(
                            text = "+639 917 967 7619",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Black,
                        )
                    }


                    Row(
                        horizontalArrangement = Arrangement.spacedBy(32.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Icon(
                            painter = rememberVectorPainter(Icons.Default.Home),
                            contentDescription = "email",
                            tint = PrimaryColor,
                            modifier = Modifier.size(24.dp)
                        )

                        Text(
                            text = "Blk 17 Lot 9 Brgy. San Dionisio Dasmarinas City of Cavite",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Black,
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(32.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Icon(
                            painter = painterResource(R.drawable.ic_business),
                            contentDescription = "email",
                            tint = PrimaryColor,
                            modifier = Modifier.size(24.dp)
                        )

                        Text(
                            text = "Business Name",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Black,
                        )
                    }


                    Row(
                        horizontalArrangement = Arrangement.spacedBy(32.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Icon(
                            painter = rememberVectorPainter(Icons.Default.LocationOn),
                            contentDescription = "email",
                            tint = PrimaryColor,
                            modifier = Modifier.size(24.dp)
                        )

                        Text(
                            text = "Business Address",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Black,
                        )
                    }
                }
            }
        }



    }
}
