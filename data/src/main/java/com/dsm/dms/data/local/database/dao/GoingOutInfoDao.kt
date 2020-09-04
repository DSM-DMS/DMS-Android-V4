package com.dsm.dms.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dsm.dms.data.local.database.entity.GoingOutInfoEntity
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single


@Dao
interface GoingOutInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveGoingOutInfoData(vararg goingOutInfo: GoingOutInfoEntity)

    @Query("SELECT * FROM `goingoutinfoentity`")
    fun getAllGoingOutInfoData(): List<GoingOutInfoEntity>?

    @Query("DELETE FROM `goingoutinfoentity` WHERE `id` = :id")
    fun deleteGoingOutInfoDataFromId(id: Int)

}
