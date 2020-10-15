package com.dsm.dms.presentation.ui.fragment.mypage.etc.notice

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingInjectFragment
import com.dsm.dms.presentation.databinding.FragmentNoticeListBinding
import com.dsm.dms.presentation.model.NoticeModel
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.notice.NoticeListViewModel
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.notice.NoticeListViewModelFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_notice_list.*
import kotlinx.android.synthetic.main.item_notice.*
import javax.inject.Inject


class NoticeListFragment: DataBindingInjectFragment<FragmentNoticeListBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_notice_list

    @Inject
    lateinit var factory: NoticeListViewModelFactory

    override val viewModel
            by lazy { ViewModelProvider(this, factory).get(NoticeListViewModel::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

    }

    override fun observeEvent() {
        viewModel.backToMyPageEvent.observe(this, Observer {
            back()
        })

        viewModel.noticeList.observe(this, Observer {
            notice_list_rcv.layoutAnimation =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_slide_from_right)
            notice_list_rcv.scheduleLayoutAnimation()
        })

        viewModel.showMessageEvent.observe(this, Observer {
            Snackbar.make(this.rootView, it, Snackbar.LENGTH_SHORT).show()
        })

        viewModel.goToDetailEvent.observe(this, Observer {

        })
    }

    private fun goToDetail(pair: Pair<View, NoticeModel>) {
        val titleTv =
            pair.first.findViewById<TextView>(R.id.item_notice_card_title_tv).apply {
                transitionName = "noticeTitleTextView"
            }
        val iconImv =
            pair.first.findViewById<ImageView>(R.id.item_notice_card_view_imv).apply {
                transitionName = "noticeViewIconImageView"
            }
        val countTv =
            pair.first.findViewById<TextView>(R.id.item_notice_card_view_tv).apply {
                transitionName = "noticeViewCountTextView"
            }
        pair.first.findViewById<TextView>(R.id.item_notice_card_view_tv)
        val extras = FragmentNavigatorExtras(
            titleTv to "noticeTitleTextView",
            iconImv to "noticeViewIconImageView",
            countTv to "noticeViewCountTextView"
        )
        findNavController().navigate(
            R.id.action_noticeListFragment_to_noticeDetailFragment,
            with(pair.second) {
                android.os.Bundle().apply {
                    putString("title", title)
                    putString("content", content)
                    putString("date", date)
                    putString("viewCount", viewCount)
                }
            }, null, extras
        )
    }

}
