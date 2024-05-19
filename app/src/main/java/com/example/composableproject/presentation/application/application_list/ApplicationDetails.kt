package com.example.composableproject.presentation.application.application_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.composableproject.ui.theme.ITEM_SPACING
import com.example.composableproject.ui.theme.PrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplicationDetailsScreen(
    navController: NavController,
    viewModel: ApplicationDetailsViewModel = hiltViewModel()
){
    val scrollState = rememberScrollState()

    val applicationData = viewModel.agentsData.collectAsState()
    val application = applicationData.value

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PrimaryColor,
                    titleContentColor = Color.White,
                ),
                title = {
                    Text(
                        text = "Application Details",
                        maxLines = 1,
                        style = MaterialTheme.typography.titleLarge,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Bold

                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowLeft,
                            tint = Color.White,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            tint = Color.White,
                            contentDescription = "Localized description"
                        )
                    }
                },
//                scrollBehavior = scrollBehavior
            )
        },

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {

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
//                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = application.referenceCode,
                        style = MaterialTheme.typography.displaySmall,
                        color = PrimaryColor,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 16.sp

                    )

                    Spacer(Modifier.height(ITEM_SPACING))

                    val applicationForm = buildAnnotatedString {
                        append("APPLICATION FORM: ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append(application.getFormTypeGroup().uppercase())
                        }
                    }

                    Text(
                        text = applicationForm,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Black,
                        lineHeight = 16.sp

                    )

                    val applicationType= buildAnnotatedString {
                        append("APPLICATION TYPE: ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append(application.getApplicationTypeAndProcessType())
                        }
                    }

                    Text(
                        text = applicationType,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Black,
                        lineHeight = 16.sp
                    )

                    val applicationDate= buildAnnotatedString {
                        append("APPLICATION DATE: ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("${application.submissionDate}  ${application.submissionTime}")
                        }
                    }

                    Text(
                        text = applicationDate,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Black,
                        lineHeight = 16.sp

                    )
//
//
//                    Status



                    Row {
                        Text(
                            text = "DECISION STATUS: ",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Black,
                            lineHeight = 16.sp

                        )


                        val decisionStatus = application.decisionStatus.toString()
                        Text(
                            text = decisionStatus,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleMedium,
                            lineHeight = 16.sp,
                            color = when(decisionStatus) {
                                "INCOMPLETE" -> Color.Black
                                "APPROVED FOR PRODUCTION","APPROVED WITH CAUTION","APPROVED" -> Color.Black
                                "DISAPPROVED" -> Color.White
                                else -> Color.Black
                            },
                            modifier = Modifier
                                .background(
                                    color = when (decisionStatus) {
                                        "INCOMPLETE" -> Color.Yellow
                                        "APPROVED FOR PRODUCTION", "APPROVED WITH CAUTION", "APPROVED" -> Color.Green
                                        "DISAPPROVED" -> Color.Red
                                        else -> Color.White
                                    },
                                    shape = RoundedCornerShape(8.dp)
                                )
//                                .padding(4.dp)
                        )
                    }


                }

            }

            /*Client Information*/
            ClientInformation(application)
            /*Material Information*/
            MaterialInformation()
            /*Document History*/
//            DocumentHistory()

        }
    }
}