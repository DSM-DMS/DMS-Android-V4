package com.dsm.dms.data.entity

import com.dsm.dms.domain.entity.ChangePassword


data class ChangePasswordData(
    var currentPassword: String,
    var newPassword: String
)

fun ChangePassword.toDataEntity() =
    ChangePasswordData(
        currentPassword = currentPassword,
        newPassword = newPassword
    )

fun ChangePasswordData.toEntity() =
    ChangePassword(
        currentPassword = currentPassword,
        newPassword = newPassword
    )
