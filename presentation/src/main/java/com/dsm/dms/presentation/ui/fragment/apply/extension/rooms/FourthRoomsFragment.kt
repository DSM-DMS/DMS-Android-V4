package com.dsm.dms.presentation.ui.fragment.apply.extension.rooms

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.dsm.dms.domain.entity.enums.ClassNum
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.changeTitleCardColor
import com.dsm.dms.presentation.databinding.FragmentApplyExtensionFourthFloorRoomsBinding
import com.dsm.dms.presentation.viewmodel.main.apply.extension.detail.ApplyExtensionFloorDetailViewModel
import kotlinx.android.synthetic.main.fragment_apply_extension_fourth_floor_rooms.*


class FourthRoomsFragment(
    override val viewModel: ApplyExtensionFloorDetailViewModel
): DataBindingFragment<FragmentApplyExtensionFourthFloorRoomsBinding>() {

    override val layoutId: Int =
        R.layout.fragment_apply_extension_fourth_floor_rooms

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
            ClassNum.FOURTH_FLOOR_SCHOOL_SIDE_ROOM -> {
                resources.changeTitleCardColor(
                    extension_fourth_floor_first_room_card,
                    extension_fourth_floor_first_room_tv,
                    isNew
                )
            }

            ClassNum.FOURTH_FLOOR_DORMITORY_SIDE_ROOM -> {
                resources.changeTitleCardColor(
                    extension_fourth_floor_second_room_card,
                    extension_fourth_floor_second_room_tv,
                    isNew
                )
            }
        }

    }
}