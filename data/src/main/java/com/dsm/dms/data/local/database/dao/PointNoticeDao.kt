package com.dsm.dms.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dsm.dms.data.local.database.entity.PointEntity


@Dao
interface PointNoticeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePointNoticeData(vararg pointEntity: PointEntity)

    @Query("SELECT * FROM `pointentity`")
    fun getAllPointNoticeData(): List<PointEntity>?

    @Query("SELECT * FROM `pointentity` WHERE `name` == :name")
    fun getPointNoticeData(name: String): PointEntity?

    @Query("DELETE FROM `pointentity` WHERE `name` == :name")
    fun deletePointNoticeData(name: String)

}
