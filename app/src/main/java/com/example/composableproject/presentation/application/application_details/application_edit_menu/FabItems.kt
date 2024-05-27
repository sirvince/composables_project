package com.example.composableproject.presentation.application.application_details.application_edit_menu

import com.example.composableproject.R


class FabItems() {
    val items = listOf(
        MultiFabItem(
            id = 1,
            iconRes = R.drawable.ic_return,
            label = "Return Application"
        ),
        MultiFabItem(
            id = 2,
            iconRes = R.drawable.ic_edit_note,
            label = "Update Application Type"
        ),
        MultiFabItem(
            id = 3,
            iconRes = R.drawable.ic_edit_note,
            label = "Update Media Type"
        ),
        MultiFabItem(
            id = 4,
            iconRes = R.drawable.ic_edit_note,
            label = "Update Material"
        )
    )

}
