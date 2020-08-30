package com.dsm.dms.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dsm.dms.data.local.database.entity.UserEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUserData(vararg myInfo: UserEntity)

    @Query("SELECT * FROM `userentity`")
    fun getUserData(): UserEntity?

    @Query("DELETE FROM `userentity`")
    fun deleteUserData()

}
