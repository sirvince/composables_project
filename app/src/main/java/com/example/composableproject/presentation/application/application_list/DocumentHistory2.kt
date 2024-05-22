package com.example.composableproject.presentation.application.application_list

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
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
import com.example.composableproject.route.Route
import com.example.composableproject.ui.theme.ITEM_SPACING
import com.example.composableproject.ui.theme.PrimaryColor
import com.example.composableproject.util.helper.LoggerUtil


@Composable
fun DocumentHistory2(application : DataObject){
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

        ) {

        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "Document Details",
                style = MaterialTheme.typography.titleLarge,
                color = PrimaryColor,
                fontWeight = FontWeight.Bold,
                lineHeight = 16.sp

            )

            Spacer(Modifier.height(ITEM_SPACING))

            val mainDocs = buildAnnotatedString {
                append("MAIN DOCS: ")
                when(application.origMainDocUrl.isNotBlank()){
                    true -> {
                        pushStringAnnotation(tag = "mainDocs","mainDocs")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,color = MaterialTheme.colorScheme.primary)) {
                            append("MAIN DOCS LINK")
                        }
                    }
                    false ->  append("NO DOCUMENT")
                }
            }

            ClickableText(
                text = mainDocs,
                style = MaterialTheme.typography.titleMedium,
            ){
                    offset -> mainDocs.getStringAnnotations(offset,offset).forEach {
                LoggerUtil().logger("ClickableText",it.tag);
            }
            }




            val supportDocs = buildAnnotatedString {
                append("SUPPORT DOCS: ")
                when(application.subDocUrl.isNotBlank()){
                    true -> {
                        pushStringAnnotation(tag = "supportDocs","supportDocs")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,color = MaterialTheme.colorScheme.primary)) {
                            append("SUPPORT DOCS LINK")
                        }
                    }
                    false ->  append("NO DOCUMENT")
                }
            }

            ClickableText(
                text = supportDocs,
                style = MaterialTheme.typography.titleMedium,
            ){
                    offset -> supportDocs.getStringAnnotations(offset,offset).forEach {
                LoggerUtil().logger("ClickableText",it.tag);
            }
            }




            val finalMaterial = buildAnnotatedString {
                append("FINAL MATERIAL: ")
                when(application.finalMaterial.isNotBlank()){
                    true -> {
                        pushStringAnnotation(tag = "finalMaterial","finalMaterial")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,color = MaterialTheme.colorScheme.primary)) {
                            append("FINAL MATERIAL LINK")
                        }
                    }
                    false ->  append("NO DOCUMENT")
                }
            }


            ClickableText(
                text = finalMaterial,
                style = MaterialTheme.typography.titleMedium,
            ){
                    offset -> finalMaterial.getStringAnnotations(offset,offset).forEach {
                LoggerUtil().logger("ClickableText",it.tag);
            }
            }


            val decisionForm = buildAnnotatedString {
                append("DECISION FORM: ")
                when(application.decisionFormURL.isNotBlank()){
                    true -> {
                        pushStringAnnotation(tag = "decisionLink","decisionLink")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,color = MaterialTheme.colorScheme.primary)) {
                            append("DECISION FORM LINK")
                        }
                    }
                    false ->  append("NO DOCUMENT")
                }
            }

            ClickableText(
                text = decisionForm,
                style = MaterialTheme.typography.titleMedium,
            ){
                offset -> decisionForm.getStringAnnotations(offset,offset).forEach {
                    LoggerUtil().logger("ClickableText",it.tag);
                }
            }


            val stampMaterial = buildAnnotatedString {
                append("STAMP MATERIAL FORM: ")
                when(application.stampMaterialUrl.isNotBlank()){
                    true -> {
                        pushStringAnnotation(tag = "stampMaterial","stampMaterial")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,color = MaterialTheme.colorScheme.primary)) {
                            append("STAMP MATERIAL LINK")
                        }
                    }
                    false ->  append("NO DOCUMENT")
                }
            }


            ClickableText(
                text = stampMaterial,
                style = MaterialTheme.typography.titleMedium,
            ){
                    offset -> stampMaterial.getStringAnnotations(offset,offset).forEach {
                LoggerUtil().logger("ClickableText",it.tag);
            }
            }


            val clearanceForm = buildAnnotatedString {
                append("CLEARANCE FORM: ")
                when(application.clearanceUrl.isNotBlank()){
                    true -> {
                        pushStringAnnotation(tag = "clearanceForm","clearanceForm")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,color = MaterialTheme.colorScheme.primary)) {
                            append("CLEARANCE LINK")
                        }
                    }
                    false ->  append("NO DOCUMENT")
                }
            }


            ClickableText(
                text = clearanceForm,
                style = MaterialTheme.typography.titleMedium,
            ){
                    offset -> clearanceForm.getStringAnnotations(offset,offset).forEach {
                LoggerUtil().logger("ClickableText",it.tag);
            }
            }



            val pendingForm = buildAnnotatedString {
                append("PENDING FORM: ")
                when(application.pendingFormUrl.isNotBlank()){
                    true -> {
                        pushStringAnnotation(tag = "clearanceForm","clearanceForm")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,color = MaterialTheme.colorScheme.primary)) {
                            append("PENDING FORM LINK")
                        }
                    }
                    false ->  append("NO DOCUMENT")
                }
            }


            ClickableText(
                text = pendingForm,
                style = MaterialTheme.typography.titleMedium,
            ){
                    offset -> pendingForm.getStringAnnotations(offset,offset).forEach {
                LoggerUtil().logger("ClickableText",it.tag);
            }
            }


            val revisionForm = buildAnnotatedString {
                append("REVISION FORM: ")
                when(application.revisionFormUrl.isNotBlank()){
                    true -> {
                        pushStringAnnotation(tag = "revisionForm","revisionForm")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,color = MaterialTheme.colorScheme.primary)) {
                            append("REVISION FORM LINK")
                        }
                    }
                    false ->  append("NO DOCUMENT")
                }
            }


            ClickableText(
                text = revisionForm,
                style = MaterialTheme.typography.titleMedium,
            ){
                    offset -> revisionForm.getStringAnnotations(offset,offset).forEach {
                LoggerUtil().logger("ClickableText",it.tag);
            }
            }


            val toaFile = buildAnnotatedString {
                append("TOA FILE: ")
                when(application.toaUrl.isNotBlank()){
                    true -> {
                        pushStringAnnotation(tag = "toaFile","toaFile")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,color = MaterialTheme.colorScheme.primary)) {
                            append("TOA FILE LINK")
                        }
                    }
                    false ->  append("NO DOCUMENT")
                }
            }


            ClickableText(
                text = toaFile,
                style = MaterialTheme.typography.titleMedium,
            ){
                    offset -> toaFile.getStringAnnotations(offset,offset).forEach {
                LoggerUtil().logger("ClickableText",it.tag);
            }
            }



        }

    }

}