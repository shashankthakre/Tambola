package com.oodles.tambolaapp2.model

data class ModelTicketsParent(
    val ticket_id: String? = null,
    val ticket_no: String? = null,
    val numbers: MutableList<ModelTicketsChild>
)