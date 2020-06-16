package com.dsm.dms.presentation.base

import android.content.Context
import androidx.activity.addCallback
import androidx.databinding.ViewDataBinding
import com.dsm.dms.presentation.toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject

abstract class EndPointDataBindingInjectFragment<V: ViewDataBinding>: DataBindingInjectFragment<V>() {

    val backButtonSubject: Subject<Long> =
        BehaviorSubject.createDefault(0L)
            .toSerialized()

    private val backButtonSubjectDisposable: Disposable = backButtonSubject
        .buffer(2, 1)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe {
            if (it[1] - it[0] <= 1500) requireActivity().finish()
            else toast(requireContext(),"뒤로가기 버튼을 한 번 더 누르시면 종료됩니다.")
        }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().onBackPressedDispatcher.addCallback {
            back()
        }
    }

    override fun back() {
        backButtonSubject.onNext(System.currentTimeMillis())
    }

    override fun onDestroy() {
        super.onDestroy()
        backButtonSubjectDisposable.dispose()
    }

}