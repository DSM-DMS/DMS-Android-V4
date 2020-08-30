package com.dsm.dms.presentation.ui.fragment.apply.extension.rooms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.changeCardViewColor
import com.dsm.dms.presentation.ui.fragment.apply.extension.ApplyExtensionFloorDetailFragment
import com.dsm.dms.presentation.viewmodel.main.apply.extension.detail.ApplyExtensionFloorDetailViewModel
import kotlinx.android.synthetic.main.fragment_apply_extension_third_floor_rooms.*
import splitties.views.onClick

class ThirdRoomsFragment(val vm: ApplyExtensionFloorDetailViewModel): Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_apply_extension_third_floor_rooms, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.changeRoom("학교측")

        extension_third_floor_first_room_card.onClick {
            vm.changeRoom("학교측")
        }
        extension_third_floor_second_room_card.onClick {
            vm.changeRoom("기숙사측")
        }
        extension_third_floor_third_room_card.onClick {
            vm.changeRoom("소파")
        }

        observeEvent(vm)
    }

    private fun observeEvent(vm: ApplyExtensionFloorDetailViewModel) {
        vm.changeNewRoomEvent.observe(this, Observer {
            changeRoom(it, true)
        })
        vm.changeOldRoomEvent.observe(this, Observer {
            changeRoom(it, false)
        })
    }

    private fun changeRoom(room: String, isNew: Boolean) {
        var cardView: CardView? = null
        var textView: TextView? = null

        when(room) {
            "학교측" -> {
                cardView = extension_third_floor_first_room_card
                textView = extension_third_floor_first_room_tv
            }
            "기숙사측" -> {
                cardView = extension_third_floor_second_room_card
                textView = extension_third_floor_second_room_tv
            }
            "소파" -> {
                cardView = extension_third_floor_third_room_card
                textView = extension_third_floor_third_room_tv
            }
        }

        changeCardViewColor(cardView, textView, resources, isNew)
    }
}