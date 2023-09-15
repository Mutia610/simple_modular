package com.mutia.local.dao

import androidx.room.*
import com.mutia.base.db.DBEntity
import com.mutia.local.entity.SourceObject
import kotlinx.coroutines.flow.Flow

@Dao
interface SourceDao {

    // PROFILE
    @Transaction
    @Query("SELECT * FROM ${DBEntity.ENTITY_SOURCE} ORDER BY id ASC LIMIT 1")
    fun getSaveSourceFlow(): Flow<List<SourceObject>>

    @Transaction
    @Query("SELECT * FROM ${DBEntity.ENTITY_SOURCE} ORDER BY id ASC LIMIT 1")
    fun getSaveSource(): List<SourceObject>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSaveSource(sourceObject: SourceObject)

}