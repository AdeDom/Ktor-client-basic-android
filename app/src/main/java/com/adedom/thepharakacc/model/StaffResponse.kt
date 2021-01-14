package com.adedom.thepharakacc.model

import kotlinx.serialization.Serializable

@Serializable
data class StaffResponse(
    val success: Boolean = false,
    val message: String? = null,
    val logo: String? = null,
    val staffList: List<Staff> ,
)
