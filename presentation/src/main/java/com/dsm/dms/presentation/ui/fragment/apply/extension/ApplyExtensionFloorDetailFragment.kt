package com.dsm.dms.presentation.ui.fragment.apply.extension

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Space
import android.widget.TextView
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.changeCardViewColor
import com.dsm.dms.presentation.databinding.FragmentApplyExtensionFloorDetailBinding
import com.dsm.dms.presentation.dp
import com.dsm.dms.presentation.ui.fragment.apply.extension.rooms.*
import com.dsm.dms.presentation.viewmodel.main.apply.extension.detail.ApplyExtensionFloorDetailViewModel
import com.dsm.dms.presentation.viewmodel.main.apply.extension.detail.ApplyExtensionFloorDetailViewModelFactory
import kotlinx.android.synthetic.main.fragment_apply_extension_floor_detail.*
import splitties.views.centerText
import splitties.views.dsl.appcompat.AppCompatStyles
import splitties.views.dsl.core.horizontalMargin
import splitties.views.dsl.core.verticalMargin
import splitties.views.onClick
import javax.inject.Inject


class ApplyExtensionFloorDetailFragment: DataBindingFragment<FragmentApplyExtensionFloorDetailBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_apply_extension_floor_detail

    @Inject
    lateinit var factory: ApplyExtensionFloorDetailViewModelFactory

    override val viewModel
            by lazy { ViewModelProvider(this, factory).get(ApplyExtensionFloorDetailViewModel::class.java) }

    private var clickedSeat: TextView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.nowFloor.value = arguments?.getInt("floor")
        binding.vm = viewModel
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().onBackPressedDispatcher.addCallback {
            back()
        }
    }

    override fun observeEvent() {
        viewModel.backToListEvent.observe(this, Observer {
            back()
        })
        viewModel.setTitleEvent.observe(this, Observer {
            extension_floor_detail_title_tv.text = "${it}층"
        })
        viewModel.setFirstFloorRoomsEvent.observe(this, Observer {
            setFloorRoomsFragment(FirstRoomsFragment(viewModel))
        })
        viewModel.setSecondFloorRoomsEvent.observe(this, Observer {
            setFloorRoomsFragment(SecondRoomsFragment(viewModel))
        })
        viewModel.setThirdFloorRoomsEvent.observe(this, Observer {
            setFloorRoomsFragment(ThirdRoomsFragment(viewModel))
        })
        viewModel.setFourthFloorRoomsEvent.observe(this, Observer {
            setFloorRoomsFragment(FourthRoomsFragment(viewModel))
        })
        viewModel.setFifthFloorRoomsEvent.observe(this, Observer {
            setFloorRoomsFragment(FifthRoomsFragment(viewModel))
        })
        viewModel.elevenClockEvent.observe(this, Observer {
            changeCardViewColor(
                extension_floor_detail_eleven_card,
                extension_floor_detail_eleven_tv,
                resources,
                it.first
            )
            changeCardViewColor(
                extension_floor_detail_twelve_card,
                extension_floor_detail_twelve_tv,
                resources,
                it.second
            )
            extension_floor_detail_eleven_card.isClickable = false
            extension_floor_detail_twelve_card.isClickable = true
        })
        viewModel.twelveClockEvent.observe(this, Observer {
            changeCardViewColor(
                extension_floor_detail_twelve_card,
                extension_floor_detail_twelve_tv,
                resources,
                it.first
            )
            changeCardViewColor(
                extension_floor_detail_eleven_card,
                extension_floor_detail_eleven_tv,
                resources,
                it.second
          )
            extension_floor_detail_eleven_card.isClickable = true
            extension_floor_detail_twelve_card.isClickable = false
        })
        viewModel.changeMapEvent.observe(this, Observer {
            drawMap(it)
        })
    }

    private fun setFloorRoomsFragment(roomsFragment: Fragment)
            = requireFragmentManager().beginTransaction()
        .replace(
            R.id.extension_floor_detail_rooms,
            roomsFragment
        ).commit()

    private fun getLayoutParam(): LinearLayout.LayoutParams {
        val seatHorizonMargin = dp(resources, 8)
        val seatVerticalMargin = dp(resources, 16)
        val seatSize = dp(resources, 50)

        val layoutParam = LinearLayout.LayoutParams(seatSize, seatSize)

        layoutParam.verticalMargin = seatVerticalMargin
        layoutParam.horizontalMargin = seatHorizonMargin

        return layoutParam
    }

    private fun createSpaceView(): View {
        val view = View(requireContext())
        view.layoutParams = getLayoutParam()
        return view
    }

    private fun createNobodySeat(styles: AppCompatStyles, seatNum: Int): TextView =
        styles.textView.spinnerItem {
            centerText()
            textSize = dp(resources,4).toFloat()
            layoutParams = getLayoutParam()
            background = resources.getDrawable(R.drawable.radius_circle_gray, null)
            onClick {
                background = resources.getDrawable(R.drawable.radius_circle_main_color, null)
                if (viewModel.selectedSeatNum.value != seatNum){
                    clickedSeat?.let {
                        clickedSeat!!.background = resources.getDrawable(R.drawable.radius_circle_gray, null)
                    }
                    clickedSeat = this
                    viewModel.selectedSeatNum.value = seatNum
                }
            }
        }

    private fun createSomeoneSeat(styles: AppCompatStyles, seatName: String): TextView =
        styles.textView.spinnerItem {
            centerText()
            textSize = dp(resources,4).toFloat()
            setTextColor(resources.getColor(R.color.colorWhite, null))
            background = resources.getDrawable(R.drawable.radius_circle_main_color, null)
            layoutParams = getLayoutParam()
            text = seatName
        }

    private fun createSpace(): Space {
        val space = Space(requireContext())
        space.layoutParams = getLayoutParam()
        return space
    }

    private fun drawMap(map: ArrayList<ArrayList<out Any>>) {
        val appCompatStyles = AppCompatStyles(requireContext())

        extension_floor_detail_map.removeAllViews()

        map.forEach { horizonMap ->
            val rowContainer = LinearLayout(requireContext())

            horizonMap.forEach { seat ->
                when (seat) {
                    is Int -> {
                        if (seat > 0)
                            rowContainer.addView(
                                createNobodySeat(appCompatStyles, seat)
                            )
                        else
                            rowContainer.addView(
                                createSpace()
                            )
                    }
                    is String ->
                        rowContainer.addView(
                            createSomeoneSeat(appCompatStyles, seat)
                        )
                    else ->
                        rowContainer.addView(
                            createSpaceView()
                        )
                }
            }
            rowContainer.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
            )
            extension_floor_detail_map.addView(rowContainer)
        }
    }
}
