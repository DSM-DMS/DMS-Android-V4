package com.dsm.dms.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dsm.dms.data.local.database.entity.MealEntity
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single


@Dao
interface MealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMealData(vararg mealEntity: MealEntity)

    @Query("SELECT * FROM `mealentity` WHERE `date` == :date")
    fun getMealData(date: String): MealEntity?

    @Query("DELETE FROM `mealentity` WHERE `date` == :date")
    fun deleteMealData(date: String)

}
