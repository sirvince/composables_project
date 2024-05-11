package com.example.composableproject.presentation.application

import com.google.gson.Gson

object SampleData {

    val jsonString = """
        [
           
            {
                "id": 1, 
                "formType": "S1", 
                "referenceCode": "H0062I051024H",
                "applicationType" : "SPECIAL SCREENING AND CLEARING",
                "brand" : "HUAWEI",
                "product" : "HUAWEI SMARTWATCH",
                "internalStatus" : "DECISION FORM HAS BEEN SENT",
                "releaseStatus" : "DISAPPROVED"
            },{
                "id": 1, 
                "formType": "S2", 
                "referenceCode": null,
                "applicationType" : "SPECIAL SCREENING AND CLEARING",
                "brand" : "HUAWEI",
                "product" : "HUAWEI SMARTWATCH",
                "internalStatus" : "DECISION FORM HAS BEEN SENT",
                "releaseStatus" : "DISAPPROVED"
            },{
                "id": 1, 
                "formType": "S1", 
                "referenceCode": "H0062I051024H",
                "applicationType" : "SPECIAL SCREENING AND CLEARING",
                "brand" : "HUAWEI",
                "product" : "HUAWEI SMARTWATCH",
                "internalStatus" : "DECISION FORM HAS BEEN SENT",
                "releaseStatus" : "DISAPPROVED"
            },{
                "id": 1, 
                "formType": "S2", 
                "referenceCode": "H0062I051024H",
                "applicationType" : "SPECIAL SCREENING AND CLEARING",
                "brand" : "HUAWEI",
                "product" : "HUAWEI SMARTWATCH",
                "internalStatus" : "DECISION FORM HAS BEEN SENT",
                "releaseStatus" : "DISAPPROVED"
            },{
                "id": 1, 
                "formType": "S1", 
                "referenceCode": "H0062I051024H",
                "applicationType" : "SPECIAL SCREENING AND CLEARING",
                "brand" : "HUAWEI",
                "product" : "HUAWEI SMARTWATCH",
                "internalStatus" : "DECISION FORM HAS BEEN SENT",
                "releaseStatus" : "DISAPPROVED"
            },{
                "id": 1, 
                "formType": "S2", 
                "referenceCode": "H0062I051024H",
                "applicationType" : "SPECIAL SCREENING AND CLEARING",
                "brand" : "HUAWEI",
                "product" : "HUAWEI SMARTWATCH",
                "internalStatus" : "DECISION FORM HAS BEEN SENT",
                "releaseStatus" : "DISAPPROVED"
            },{
                "id": 1, 
                "formType": "S1", 
                "referenceCode": "H0062I051024H",
                "applicationType" : "SPECIAL SCREENING AND CLEARING",
                "brand" : "HUAWEI",
                "product" : "HUAWEI SMARTWATCH",
                "internalStatus" : "DECISION FORM HAS BEEN SENT",
                "releaseStatus" : "DISAPPROVED"
            },{
                "id": 1, 
                "formType": "S2", 
                "referenceCode": "H0062I051024H",
                "applicationType" : "SPECIAL SCREENING AND CLEARING",
                "brand" : "HUAWEI",
                "product" : "HUAWEI SMARTWATCH",
                "internalStatus" : "DECISION FORM HAS BEEN SENT",
                "releaseStatus" : "DISAPPROVED"
            }
       
            
        ]
    """

    // Step 2: Convert JSON string to a list of Person objects using Gson
    private val gson = Gson()
    val applicationList: List<Application> = gson.fromJson(jsonString, Array<Application>::class.java).toList()


}