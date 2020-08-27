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

    @Query("SELECT * FROM `mapentity` WHERE `id` == :id")
    fun getMapData(id: String): MapEntity?

    @Query("DELETE FROM `mapentity` WHERE `id` == :id")
    fun deleteMapData(id: String)

}
