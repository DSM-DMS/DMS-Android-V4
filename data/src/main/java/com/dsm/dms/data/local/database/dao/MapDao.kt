package com.dsm.dms.data.local.database.dao

import androidx.room.*
import com.dsm.dms.data.local.database.entity.MapEntity
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single


@Dao
interface MapDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMapData(vararg mapEntity: MapEntity)

    @Query("SELECT * FROM `mapentity`")
    fun getAllMapData(): List<MapEntity>?

    @Query("SELECT * FROM `mapentity` WHERE `time` == :time AND `classNum` == :classNum")
    fun getMapData(time: Int, classNum: Int): MapEntity?

    @Query("DELETE FROM `mapentity` WHERE `time` == :time AND `classNum` == :classNum")
    fun deleteMapData(time: Int, classNum: Int)

}
