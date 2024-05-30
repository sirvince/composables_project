package com.example.composableproject.presentation.application.application_list


import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.composableproject.component.LoadingDialog
import com.example.composableproject.presentation.login.AlertDialogState
import com.example.composableproject.ui.theme.ITEM_SPACING
import com.example.composableproject.ui.theme.PrimaryColor
import com.example.composableproject.util.helper.LoggerUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplicationDetailsScreen(
    navController: NavController,
    viewModel: ApplicationDetailsViewModel = hiltViewModel()
){
    val applicationId = navController.currentBackStackEntry?.arguments?.getInt("applicationId")
    var onFetch by remember { mutableStateOf(false) }
    var alertDialogState by remember { mutableStateOf(AlertDialogState()) }

    if (onFetch) {
        LoadingDialog()
    }

    LaunchedEffect(applicationId) {
        if (applicationId != null) viewModel.loadApplicationData(applicationId)
    }

    val context = LocalContext.current
    LaunchedEffect(key1 = context) {
        viewModel.validationEvents.collect{ event ->
            when(event){
                ApplicationDetailsViewModel.ValidationEvent.Success -> {
                    onFetch = false
                }
                ApplicationDetailsViewModel.ValidationEvent.Loading -> {
                    onFetch = true
                }
                is ApplicationDetailsViewModel.ValidationEvent.Error -> {
                    onFetch = false
                    alertDialogState = AlertDialogState(
                        showDialog = true,
                        title = "Login Failed!",
                        message = event.errorMessage
                    )
                }
            }
        }
    }

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



            if(!onFetch){
                ApplicationInfo(application)
                ClientInformation(application)
                ApplicantInformation(application)
                MaterialInformation(application)
                DocumentHistory2(application)
            }else{

            }

        }
    }
}