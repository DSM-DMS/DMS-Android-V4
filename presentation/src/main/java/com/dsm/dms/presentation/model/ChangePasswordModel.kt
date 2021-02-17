package com.dsm.dms.presentation.model

import com.dsm.dms.domain.`object`.ChangePassword

data class ChangePasswordModel(
    var currentPassword: String,
    var newPassword: String
)

fun ChangePasswordModel.toEntity() =
    ChangePassword(
        currentPassword = currentPassword,
        newPassword = newPassword
    )

fun ChangePassword.toModel() =
    ChangePasswordModel(
        currentPassword = currentPassword,
        newPassword = newPassword
    )
