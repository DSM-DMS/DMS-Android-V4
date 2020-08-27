package com.dsm.dms.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dsm.dms.data.local.database.entity.ExtensionInfoEntity

@Dao
interface ApplyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveExtensionInfoData(vararg extensionInfo: ExtensionInfoEntity)

    @Query("SELECT * FROM `extensioninfoentity`")
    fun getAllExtensionInfoData(): List<ExtensionInfoEntity>?

    @Query("SELECT * FROM `extensioninfoentity` WHERE `time` = :time")
    fun getExtensionInfoDataFromTime(time: Int): ExtensionInfoEntity?

    @Query("DELETE FROM `extensioninfoentity` WHERE time = :time")
    fun deleteExtensionInfoDataFromTime(time: Int)
}
