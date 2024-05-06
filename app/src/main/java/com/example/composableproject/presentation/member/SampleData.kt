package com.example.composableproject.presentation.member

import com.google.gson.Gson

object SampleData {

    val jsonString = """
        [
           
            {
                "id": 1, 
                "firstName": "John Vincent", 
                "lastName": "Dallego",
                "position" : "Member",
                "contactNumber" : "09123456789",
                "isActive" : true
            }, {
                "id": 1, 
                "firstName": "John Vincent", 
                "lastName": "Dallego",
                "position" : "Member",
                "contactNumber" : "09123456789"
            }, {
                "id": 1, 
                "firstName": "John Vincent", 
                "lastName": "Dallego",
                "position" : "Member",
                "contactNumber" : "09123456789"
            }, {
                "id": 1, 
                "firstName": "John Vincent", 
                "lastName": "Dallego",
                "position" : "Member",
                "contactNumber" : "09123456789"
            }, {
                "id": 1, 
                "firstName": "John Vincent", 
                "lastName": "Dallego",
                "position" : "Member",
                "contactNumber" : "09123456789"
            }, {
                "id": 1, 
                "firstName": "John Vincent", 
                "lastName": "Dallego",
                "position" : "Member",
                "contactNumber" : "09123456789"
            }, {
                "id": 1, 
                "firstName": "John Vincent", 
                "lastName": "Dallego",
                "position" : "Member",
                "contactNumber" : "09123456789"
            }, {
                "id": 1, 
                "firstName": "John Vincent", 
                "lastName": "Dallego",
                "position" : "Member",
                "contactNumber" : "09123456789"
            }, {
                "id": 1, 
                "firstName": "John Vincent", 
                "lastName": "Dallego",
                "position" : "Member",
                "contactNumber" : "09123456789"
            }, {
                "id": 1, 
                "firstName": "John Vincent", 
                "lastName": "Dallego",
                "position" : "Member",
                "contactNumber" : "09123456789"
            }, {
                "id": 1, 
                "firstName": "John Vincent", 
                "lastName": "Dallego",
                "position" : "Member",
                "contactNumber" : "09123456789"
            }, {
                "id": 1, 
                "firstName": "John Vincent", 
                "lastName": "Dallego",
                "position" : "Member",
                "contactNumber" : "09123456789"
            }, {
                "id": 1, 
                "firstName": "John Vincent", 
                "lastName": "Dallego",
                "position" : "Member",
                "contactNumber" : "09123456789"
            }, {
                "id": 1, 
                "firstName": "John Vincent", 
                "lastName": "Dallego",
                "position" : "Member",
                "contactNumber" : "09123456789"
            }, {
                "id": 1, 
                "firstName": "John Vincent", 
                "lastName": "Dallego",
                "position" : "Member",
                "contactNumber" : "09123456789"
            }, {
                "id": 1, 
                "firstName": "John Vincent", 
                "lastName": "Dallego",
                "position" : "Member",
                "contactNumber" : "09123456789"
            }, {
                "id": 1, 
                "firstName": "John Vincent", 
                "lastName": "Dallego",
                "position" : "Member",
                "contactNumber" : "09123456789"
            }
        ]
    """

    // Step 2: Convert JSON string to a list of Person objects using Gson
    private val gson = Gson()
    val personList: List<Member> = gson.fromJson(jsonString, Array<Member>::class.java).toList()


}