package com.dsm.dms.presentation.ui.fragment.apply.extension

import android.content.Context
import android.os.Bundle
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
import com.dsm.dms.presentation.base.DataBindingInjectFragment
import com.dsm.dms.presentation.changeTitleCardColor
import com.dsm.dms.presentation.databinding.FragmentApplyExtensionFloorDetailBinding
import com.dsm.dms.presentation.dp
import com.dsm.dms.presentation.ui.fragment.apply.extension.rooms.*
import com.dsm.dms.presentation.viewmodel.main.apply.extension.detail.ApplyExtensionFloorDetailViewModel
import com.dsm.dms.presentation.viewmodel.main.apply.extension.detail.ApplyExtensionFloorDetailViewModelFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_apply_extension_floor_detail.*
import splitties.views.centerText
import splitties.views.dsl.appcompat.AppCompatStyles
import splitties.views.dsl.core.horizontalMargin
import splitties.views.dsl.core.verticalMargin
import splitties.views.onClick
import javax.inject.Inject


class ApplyExtensionFloorDetailFragment: DataBindingInjectFragment<FragmentApplyExtensionFloorDetailBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_apply_extension_floor_detail

    @Inject
    lateinit var factory: ApplyExtensionFloorDetailViewModelFactory

    override val viewModel
            by lazy { ViewModelProvider(this, factory).get(ApplyExtensionFloorDetailViewModel::class.java) }

    private var clickedSeat: TextView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        viewModel.nowFloor.value = arguments?.getInt("floor")
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

        viewModel.nowFloor.observe(this, Observer {
            searchFloorRoomsFragment(it)
        })

        viewModel.elevenClockEvent.observe(this, Observer {
            changeClockColor(true)
        })

        viewModel.twelveClockEvent.observe(this, Observer {
            changeClockColor(false)
        })

        viewModel.changeMapEvent.observe(this, Observer {
            drawMap(it)
        })

        viewModel.showMessageEvent.observe(this, Observer {
            Snackbar.make(this.rootView, it, Snackbar.LENGTH_SHORT).show()
        })

        viewModel.onLoadEvent.observe(this, Observer {
            extension_floor_detail_apply_btn.onLoad(it)
        })

        viewModel.onErrorEvent.observe(this, Observer {
            extension_floor_detail_apply_btn.onError(it)
        })

        viewModel.onSuccessEvent.observe(this, Observer {
            extension_floor_detail_apply_btn.onSuccess(it)
        })
    }

    private fun changeClockColor(isEleven: Boolean) {
        resources.changeTitleCardColor(
            extension_floor_detail_eleven_card,
            extension_floor_detail_eleven_tv,
            isEleven
        )
        resources.changeTitleCardColor(
            extension_floor_detail_twelve_card,
            extension_floor_detail_twelve_tv,
            isEleven.not()
        )

        extension_floor_detail_eleven_card.isClickable = isEleven.not()
        extension_floor_detail_twelve_card.isClickable = isEleven
    }

    private fun searchFloorRoomsFragment(floor: Int) {
        when(floor) {
            1 -> setFloorRoomsFragment(FirstRoomsFragment(viewModel))
            2 -> setFloorRoomsFragment(SecondRoomsFragment(viewModel))
            3 -> setFloorRoomsFragment(ThirdRoomsFragment(viewModel))
            4 -> setFloorRoomsFragment(FourthRoomsFragment(viewModel))
            5 -> setFloorRoomsFragment(FifthRoomsFragment(viewModel))
        }
    }

    private fun setFloorRoomsFragment(roomsFragment: Fragment)
            = requireFragmentManager().beginTransaction()
        .replace(
            R.id.extension_floor_detail_rooms,
            roomsFragment
        ).commit()

    private fun getLayoutParam(): LinearLayout.LayoutParams {
        val seatHorizonMargin = resources.dp(8)
        val seatVerticalMargin = resources.dp(16)
        val seatSize = resources.dp(50)

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
            textSize = resources.dp(4).toFloat()
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
            textSize = resources.dp(4).toFloat()
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

    private fun addSeatView(
        seat: Any,
        rowContainer: LinearLayout,
        appCompatStyles: AppCompatStyles
    ) {
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

    private fun drawMap(map: List<List<Any>>) {
        val appCompatStyles = AppCompatStyles(requireContext())

        extension_floor_detail_map.removeAllViews()

        map.forEach { horizonMap ->
            val rowContainer = LinearLayout(requireContext())

            horizonMap.forEach { seat ->
                addSeatView(seat, rowContainer, appCompatStyles)
            }
            rowContainer.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
            )
            extension_floor_detail_map.addView(rowContainer)
        }
    }
}
