package com.example.composableproject.data.model

import com.google.gson.annotations.SerializedName

data class DataObject(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("form_type") val formType: String = "",
    @SerializedName("form_group") val formGroup: String = "",
    @SerializedName("referrence_code") val referenceCode: String = "",
    @SerializedName("prev_refcode") val prevRefCode: String = "",
    @SerializedName("application_type") val applicationType: String = "",
    @SerializedName("slugified_app_type") val slugifiedAppType: String = "",
    @SerializedName("process_type") val processType: String = "",
    @SerializedName("brand") val brand: String = "",
    @SerializedName("product") val product: String = "",
    @SerializedName("category") val category: String = "",
    @SerializedName("type_of_media") val typeOfMedia: String = "",
    @SerializedName("hasBirFormFiled") val hasBirFormFiled: Int = 0,
    @SerializedName("is_complain") val isComplain: Int = 0,
    @SerializedName("isRejected") val isRejected: Int = 0,
    @SerializedName("payment_status") val paymentStatus: String = "",
    @SerializedName("payment_date") val paymentDate: String = "",
    @SerializedName("payment_type") val paymentType: String = "",
    @SerializedName("isPaidByApplicant") val isPaidByApplicant: Int = 0,
    @SerializedName("proof_of_payment") val proofOfPayment: String = "",
    @SerializedName("payment_remarks") val paymentRemarks: String = "",
    @SerializedName("amount") val amount: String = "",
    @SerializedName("paid_amount") val paidAmount: String = "",
    @SerializedName("bank_name") val bankName: String = "",
    @SerializedName("bank_branch") val bankBranch: String = "",
    @SerializedName("control_number") val controlNumber: String = "",
    @SerializedName("transfer_date") val transferDate: String = "",
    @SerializedName("promisory_date") val promissoryDate: String = "",
    @SerializedName("has_official_receipt") val hasOfficialReceipt: Int = 0,
    @SerializedName("ad_title") val adTitle: String = "",
    @SerializedName("tag_line") val tagLine: String = "",
    @SerializedName("hasNoSubDocs") val hasNoSubDocs: Int = 0,
    @SerializedName("is_maindoc_required") val isMainDocRequired: Int = 0,
    @SerializedName("origMainDocUrl") val origMainDocUrl: String = "",
    @SerializedName("subDocUrl") val subDocUrl: String = "",
    @SerializedName("revision_letter") val revisionLetter: String = "",
    @SerializedName("final_material") val finalMaterial: String = "",
    @SerializedName("decisionFormURL") val decisionFormURL: String = "",
    @SerializedName("stampMaterialUrl") val stampMaterialUrl: String = "",
    @SerializedName("clearance_url") val clearanceUrl: String = "",
    @SerializedName("revisionform_url") val revisionFormUrl: String = "",
    @SerializedName("toa_url") val toaUrl: String = "",
    @SerializedName("pendingform_url") val pendingFormUrl: String = "",
    @SerializedName("hasSubmitted") val hasSubmitted: Int = 0,
    @SerializedName("Int = 0ernal_comment") val internalComment: String = "",
    @SerializedName("external_comment") val externalComment: String = "",
    @SerializedName("applicant_status") val applicantStatus: String = "",
    @SerializedName("Int = 0ernal_status") val internalStatus: String = "",
    @SerializedName("decision_status") val decisionStatus: String = "",
    @SerializedName("release_status") val releaseStatus: String = "",
    @SerializedName("isLocked") val isLocked: Int = 0,
    @SerializedName("forCompliance") val forCompliance: Int = 0,
    @SerializedName("forS2") val forS2: Int = 0,
    @SerializedName("forRevision") val forRevision: Int = 0,
    @SerializedName("forToa") val forToa: Int = 0,
    @SerializedName("application_date") val applicationDate: String = "",
    @SerializedName("submission_date") val submissionDate: String = "",
    @SerializedName("submission_time") val submissionTime: String = "",
    @SerializedName("decision_status_date") val decisionStatusDate: String = "",
    @SerializedName("release_date") val releaseDate: String = "",
    @SerializedName("issued_date") val issuedDate: String = "",
    @SerializedName("valid_until_date") val validUntilDate: String = "",
    @SerializedName("modified_at") val modifiedAt: String = "",
    @SerializedName("archived_at") val archivedAt: String = "",
    @SerializedName("verifiedDateByEvaluator") val verifiedDateByEvaluator: String = "",
    @SerializedName("verifiedDateByAdSpe") val verifiedDateByAdSpe: String = "",
    @SerializedName("verifiedDateByScreener") val verifiedDateByScreener: String = "",
    @SerializedName("verifiedDateByReviewer") val verifiedDateByReviewer: String = "",
    @SerializedName("is_recent") val isRecent: Int = 0,
    @SerializedName("revision_count") val revisionCount: Int = 0,
    @SerializedName("company") val company: Company ? = null,
    @SerializedName("type_of_medium") val typeOfMedium: List<TypeOfMedium> ? = null,
    @SerializedName("assigned_user") val assignedUser: AssignedUser ? = null,
    @SerializedName("assigned_userRole") val assignedUserRole: AssignedUserRole ? = null,
    @SerializedName("evaluator") val evaluator: Evaluator ? = null,
    @SerializedName("ad_specialist") val adSpecialist: String = "",
    @SerializedName("screener") val screener: String = "",
    @SerializedName("reviewer") val reviewer: String = "",
    @SerializedName("applicant") val applicant: Applicant ? = null,
    @SerializedName("document_type") val documentType: List<DocumentType> ? = null
){

    fun getFormTypeGroup(): String  {
        return "$formType - $formGroup"
    }

    fun getApplicationTypeAndProcessType(): String {
        return "$applicationType - $processType"
    }


    fun getBrandProduct(): String {
        return "$brand - $product"
    }


    fun getSubmissionDateTime(): String  {
        return "APPLICATION DATE: $submissionDate $submissionTime"
    }
}



