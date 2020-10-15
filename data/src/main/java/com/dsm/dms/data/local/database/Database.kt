package com.dsm.dms.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dsm.dms.data.local.database.converter.*
import com.dsm.dms.data.local.database.dao.*
import com.dsm.dms.data.local.database.entity.*


@Database(entities = [
    UserEntity::class,
    ExtensionInfoEntity::class,
    GoingOutInfoEntity::class,
    MapEntity::class,
    NoticeEntity::class,
    ScheduleEntity::class,
    MealEntity::class
], version = 1, exportSchema = false)
@TypeConverters(
    GoingOutTypeConverter::class,
    StayInfoConverter::class,
    MapConverter::class,
    StringListConverter::class,
    ClassNumConverter::class
)
abstract class Database: RoomDatabase() {

    abstract val userDao: UserDao

    abstract val goingOutInfoDao: GoingOutInfoDao

    abstract val extensionInfoDao: ExtensionInfoDao

    abstract val mapDao: MapDao

    abstract val noticeDao: NoticeDao

    abstract val scheduleDao: ScheduleDao

    abstract val mealDao: MealDao

}
