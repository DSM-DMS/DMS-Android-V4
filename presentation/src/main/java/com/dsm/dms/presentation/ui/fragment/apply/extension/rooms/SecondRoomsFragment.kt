package com.dsm.dms.presentation.ui.fragment.apply.extension.rooms

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.dsm.dms.domain.entity.enums.ClassNum
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.changeTitleCardColor
import com.dsm.dms.presentation.databinding.FragmentApplyExtensionSecondFloorRoomsBinding
import com.dsm.dms.presentation.viewmodel.main.apply.extension.detail.ApplyExtensionFloorDetailViewModel
import kotlinx.android.synthetic.main.fragment_apply_extension_second_floor_rooms.*


class SecondRoomsFragment(
    override val viewModel: ApplyExtensionFloorDetailViewModel
): DataBindingFragment<FragmentApplyExtensionSecondFloorRoomsBinding>() {

    override val layoutId: Int =
        R.layout.fragment_apply_extension_second_floor_rooms

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
    }

    override fun observeEvent() {
        viewModel.changeNewClassEvent.observe(this, Observer {
            changeClass(it, true)
        })
        viewModel.changeOldClassEvent.observe(this, Observer {
            changeClass(it, false)
        })
    }

    private fun changeClass(classNum: ClassNum, isNew: Boolean) {
        when(classNum) {
            ClassNum.SECOND_FLOOR_ROOM -> {
                resources.changeTitleCardColor(
                    extension_second_floor_first_room_card,
                    extension_second_floor_first_room_tv,
                    isNew
                )
            }
        }
    }
}