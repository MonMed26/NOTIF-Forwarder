package com.zerodev.smsforwarder.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "app_filters")
data class AppFilterEntity(
    @PrimaryKey val packageName: String,
    val appLabel: String,
    val enabled: Boolean = true
)
