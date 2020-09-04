package com.dsm.dms.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dsm.dms.data.local.database.entity.ScheduleEntity
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single


@Dao
interface ScheduleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveScheduleData(vararg ScheduleEntity: ScheduleEntity)

    @Query("SELECT * FROM `scheduleentity`")
    fun getAllScheduleData(): List<ScheduleEntity>?

    @Query("SELECT * FROM `scheduleentity` WHERE `id` == :id")
    fun getScheduleData(id: Int): ScheduleEntity?

    @Query("DELETE FROM `scheduleentity` WHERE `id` == :id")
    fun deleteScheduleData(id: Int)

}
