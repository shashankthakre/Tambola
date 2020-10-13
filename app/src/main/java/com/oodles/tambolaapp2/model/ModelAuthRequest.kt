package com.oodles.tambolaapp2.model

data class ModelAuthRequest(
    val phone_number: String? = null,
    val registration_code: String? = null,
    val device_type: String? = null,
    val device_token: String? = null,
    val os_version: String? = null,
    val device_model: String? = null,
)
