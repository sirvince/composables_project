package com.example.composableproject.presentation.application.application_details

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.composableproject.R
import com.example.composableproject.component.CenteredImage
import com.example.composableproject.component.SearchInputTextField
import com.example.composableproject.presentation.application.SampleData
import com.example.composableproject.ui.theme.PrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplicationListScreen(
    navController: NavController,
    viewModel: ApplicationViewModel = hiltViewModel()
){
    val memberList = remember {
        SampleData.applicationList
    }


    val ( search , setSearch ) = rememberSaveable {
        mutableStateOf("")
    }

    val context = LocalContext.current
    val agentsData = viewModel.agentsData.collectAsState()

    LaunchedEffect(key1 = context) {
        viewModel.validationEvents.collect{ event ->
            when(event){
                is ApplicationViewModel.ValidationEvent.Error -> {
                    Toast.makeText(context,"Error",Toast.LENGTH_LONG).show()
                }
                is ApplicationViewModel.ValidationEvent.Loading -> {
                    Toast.makeText(context,"Loading",Toast.LENGTH_LONG).show()
                }
                is ApplicationViewModel.ValidationEvent.Success -> {

                }
            }
        }
    }




    Scaffold(
//        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = PrimaryColor,
                    titleContentColor = Color.White,
                ),
                title = {
                    Text(
                        text = "Application",
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
        bottomBar = {
//            BottomAppBar(
//                containerColor = MaterialTheme.colorScheme.primaryContainer,
//                contentColor = MaterialTheme.colorScheme.primary,
//            ) {
//                Text(
//                    modifier = Modifier.fillMaxWidth(),
//                    textAlign = TextAlign.Center,
//                    text = "Bottom app bar",
//                )
//            }
        },
//        floatingActionButton = {
//            FloatingActionButton(
//                onClick = {
////                    val applicationFilter = ApplicationFilterDto(
////                        applicationType = listOf("ALL"),
////                        formGroup =  "ALL",
////                        search = "",
////                        processType = "ALL",
////                        formType = "s1"
////                    )
////                    viewModel.onEvent(ApplicationFormEvent.GetApplication(1,1,applicationFilter))
//                },
//                containerColor = TertiaryColor
//            ) {
//                Icon(
//                    Icons.Default.Add,
//                    tint = Color.White,
//                    contentDescription = "Add"
//                )
//            }
//        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {

            //search
            SearchInputTextField(
                value = search,
                onValueChange = setSearch,
                onDone = { if(search.isNotEmpty()) viewModel.onEvent(ApplicationFormEvent.GetApplication(10,1,search))
                           else viewModel.clearAgentsData()
                         },
                labelText = "Search application using reference code,brand,product...",
                leadingIcon = Icons.Default.Search,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
                modifier = Modifier.fillMaxHeight()
            ) {
                if (agentsData.value.isNotEmpty()) {
                    items(count = agentsData.value.size) { index ->
                        ApplicationItem(navController, agentsData.value[index])
                    }
                } else {
                    item {
                        CenteredImage(
                            painter = painterResource(id = R.drawable.ic_searching),
                            modifier = Modifier.fillMaxSize().size(400.dp).align(Alignment.CenterHorizontally),
                            contentDescription = "No Content"
                        )
                    }
                }
            }
        }
    }

}