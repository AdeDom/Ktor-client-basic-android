package com.adedom.thepharakacc.model

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse(
    val success: Boolean = false,
    val message: String? = null,
)
