package com.dsm.dms.presentation

import android.content.Context
import android.content.res.Resources
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.MutableLiveData


fun MutableLiveData<String>.isValueBlank() = this.value.isNullOrBlank()

fun toast(context: Context, message: String) = Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

fun dp(resources: Resources, value: Int): Int = (value * resources.displayMetrics.density).toInt()

fun changeCardViewColor(card: CardView?, text: TextView?, resources: Resources, isNew: Boolean) {
    if (isNew) {
        card?.setCardBackgroundColor(
            resources.getColor(R.color.colorMain, null)
        )

        text?.setTextColor(
            resources.getColor(R.color.colorWhite, null)
        )
    } else {
        card?.setCardBackgroundColor(
            resources.getColor(R.color.colorNightWhite, null)
        )

        text?.setTextColor(
            resources.getColor(R.color.colorNightBlack, null)
        )
    }
}

fun changeColor(resources: Resources, card: CardView, title: AppCompatTextView, content: AppCompatTextView) {
    card.setCardBackgroundColor(
        resources.getColor(R.color.colorMain, null)
    )
    title.setTextColor(resources.getColor(R.color.colorWhite, null))
    content.setTextColor(resources.getColor(R.color.colorWhite, null))
}

fun originalColor(resources: Resources, card: CardView, title: AppCompatTextView, content: AppCompatTextView) {
    card.setCardBackgroundColor(
        resources.getColor(R.color.colorNightViewBackgroundDefault, null)
    )
    title.setTextColor(resources.getColor(R.color.colorNightBlack, null))
    content.setTextColor(resources.getColor(R.color.colorNightViewColorDefault, null))
}

fun String.intOrString() = toIntOrNull() ?: this
