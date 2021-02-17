package com.dsm.dms.presentation.ui.fragment.apply.extension.rooms

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.dsm.dms.domain.entity.enums.ClassNum
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.changeTitleCardColor
import com.dsm.dms.presentation.databinding.FragmentApplyExtensionFirstFloorRoomsBinding
import com.dsm.dms.presentation.viewmodel.main.apply.extension.detail.ApplyExtensionFloorDetailViewModel
import kotlinx.android.synthetic.main.fragment_apply_extension_first_floor_rooms.*


class FirstRoomsFragment(
    override val viewModel: ApplyExtensionFloorDetailViewModel
): DataBindingFragment<FragmentApplyExtensionFirstFloorRoomsBinding>() {

    override val layoutId: Int =
        R.layout.fragment_apply_extension_first_floor_rooms

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
             ClassNum.GAONSIL -> {
                resources.changeTitleCardColor(
                    extension_first_floor_first_room_card,
                    extension_first_floor_first_room_tv,
                    isNew
                )
            }
            ClassNum.NAONSIL -> {
                resources.changeTitleCardColor(
                    extension_first_floor_second_room_card,
                    extension_first_floor_second_room_tv,
                    isNew
                )
            }
            ClassNum.DAONSIL -> {
                resources.changeTitleCardColor(
                    extension_first_floor_third_room_card,
                    extension_first_floor_third_room_tv,
                    isNew
                )
            }
            ClassNum.LAONSIL -> {
                resources.changeTitleCardColor(
                    extension_first_floor_fourth_room_card,
                    extension_first_floor_fourth_room_tv,
                    isNew
                )
            }
        }
    }
}