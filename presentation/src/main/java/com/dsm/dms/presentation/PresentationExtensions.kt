package com.dsm.dms.presentation

import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.presentation.bindingAdapter.RecyclerItem
import com.dsm.dms.presentation.model.MusicModel
import com.dsm.dms.presentation.model.VisibilityModel


fun MutableLiveData<String>.isValueBlank() = this.value.isNullOrBlank()

fun Context.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Resources.dp(value: Int): Int = (value * this.displayMetrics.density).toInt()

fun Resources.changeTitleCardColor(card: CardView?, text: TextView?, isNew: Boolean) {
    if (isNew) {
        card?.setCardBackgroundColor(
            this.getColor(R.color.colorMain, null)
        )

        text?.setTextColor(
            this.getColor(R.color.colorWhite, null)
        )
    } else {
        card?.setCardBackgroundColor(
            this.getColor(R.color.colorNightWhiteToGray, null)
        )

        text?.setTextColor(
            this.getColor(R.color.colorNightBlack, null)
        )
    }
}

fun Resources.changeContentCardColor(card: CardView, title: AppCompatTextView, content: AppCompatTextView) {
    card.setCardBackgroundColor(
        this.getColor(R.color.colorMain, null)
    )
    title.setTextColor(this.getColor(R.color.colorWhite, null))
    content.setTextColor(this.getColor(R.color.colorWhite, null))
}

fun Resources.originContentCardColor(card: CardView, title: AppCompatTextView, content: AppCompatTextView) {
    card.setCardBackgroundColor(
        this.getColor(R.color.colorNightViewBackgroundDefault, null)
    )
    title.setTextColor(this.getColor(R.color.colorNightBlack, null))
    content.setTextColor(this.getColor(R.color.colorNightViewColorDefault, null))
}

fun String.intOrString() = toIntOrNull() ?: this

fun String?.isNotNullOrBlank() = !isNullOrBlank()

fun <T> T?.isNotNull(): Boolean =
    this?.let {
        return true
    }.let {
        return false
    }

fun VisibilityModel.onErrorShow(resource: Int) {
    errorResource = resource
    visibleContent = View.GONE
    visibleError = View.VISIBLE
}

fun MutableLiveData<VisibilityModel>.updateVisibility(
    update: (VisibilityModel) -> Unit
) {
    value?.let {
        update(it)
    }.let {
        postValue(value)
    }
}
