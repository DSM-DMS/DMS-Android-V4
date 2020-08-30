package com.dsm.dms.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dsm.dms.data.local.database.entity.NoticeEntity
import com.dsm.dms.data.local.database.entity.PointEntity
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single


@Dao
interface NoticeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNoticeData(vararg noticeEntity: NoticeEntity)

    @Query("SELECT * FROM `noticeentity`")
    fun getAllNoticeData(): List<NoticeEntity>?

    @Query("SELECT * FROM `noticeentity` WHERE `id` == :id")
    fun getNoticeData(id: Int): NoticeEntity?

    @Query("DELETE FROM `noticeentity` WHERE `id` == :id")
    fun deleteNoticeData(id: Int)

}
