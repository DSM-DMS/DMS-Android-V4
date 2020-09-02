package com.dsm.dms.data.`object`

import com.dsm.dms.domain.`object`.ChangePassword


data class ChangePasswordData(
    var currentPassword: String,
    var newPassword: String
)

fun ChangePassword.toDataObject() =
    ChangePasswordData(
        currentPassword = currentPassword,
        newPassword = newPassword
    )

fun ChangePasswordData.toObject() =
    ChangePassword(
        currentPassword = currentPassword,
        newPassword = newPassword
    )
