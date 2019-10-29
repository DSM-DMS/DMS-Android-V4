package com.dsm.dms.presentation

import androidx.lifecycle.MutableLiveData

fun MutableLiveData<String>.isValueBlank() = this.value.isNullOrBlank()