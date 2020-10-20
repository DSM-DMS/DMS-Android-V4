package com.dsm.dms.presentation.model

import android.os.Parcel
import android.os.Parcelable
import com.dsm.dms.domain.entity.Notice


data class NoticeModel(
    val id: Int,
    val title: String,
    val content: String,
    val viewCount: String,
    val date: String,
    val isViewed: Boolean
): Parcelable {
    constructor(parcel: Parcel) : this(
        id = parcel.readInt(),
        title = parcel.readString().toString(),
        content = parcel.readString().toString(),
        viewCount = parcel.readString().toString(),
        date = parcel.readString().toString(),
        isViewed = parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(content)
        parcel.writeString(viewCount)
        parcel.writeString(date)
        parcel.writeByte(if (isViewed) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NoticeModel> {
        override fun createFromParcel(parcel: Parcel): NoticeModel {
            return NoticeModel(parcel)
        }

        override fun newArray(size: Int): Array<NoticeModel?> {
            return arrayOfNulls(size)
        }
    }
}

fun NoticeModel.toEntity() =
    Notice(
        id = id,
        date = date,
        title = title,
        content = content,
        views = viewCount.toInt(),
        isViewed = isViewed
    )

fun Notice.toModel() =
    NoticeModel(
        id = id,
        date = date,
        title = title,
        content = content,
        viewCount = views.toString(),
        isViewed = isViewed
    )
