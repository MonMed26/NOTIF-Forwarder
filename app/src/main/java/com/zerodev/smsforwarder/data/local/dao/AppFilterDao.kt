package com.zerodev.smsforwarder.data.local.dao

import androidx.room.*
import com.zerodev.smsforwarder.data.local.entity.AppFilterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppFilterDao {
    @Query("SELECT * FROM app_filters ORDER BY appLabel")
    fun observeAll(): Flow<List<AppFilterEntity>>

    @Query("SELECT enabled FROM app_filters WHERE packageName = :pkg LIMIT 1")
    suspend fun isEnabled(pkg: String): Boolean?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(items: List<AppFilterEntity>)

    @Update
    suspend fun update(item: AppFilterEntity)
}
