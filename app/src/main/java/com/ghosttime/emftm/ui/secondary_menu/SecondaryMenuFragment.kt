package com.ghosttime.emftm.ui.secondary_menu

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ghosttime.emftm.R
import com.ghosttime.emftm.databinding.FragmentSecondaryMenuBinding
import com.ghosttime.emftm.ui.main.MainActivity
import com.ghosttime.emftm.ui.main_two.InfoForContinue

class SecondaryMenuFragment : Fragment() {

    private lateinit var viewBinding: FragmentSecondaryMenuBinding
    private val contextActivity: MainActivity by lazy(LazyThreadSafetyMode.NONE) {
        (activity as MainActivity)
    }

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contextActivity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        return inflater.inflate(R.layout.fragment_secondary_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentSecondaryMenuBinding.bind(view)

        with(viewBinding) {
            secondaryMenuBackImgBtn.setOnClickListener {
                if (contextActivity.presenter.getCheckSound()) {
                    contextActivity.startSound()
                }
                contextActivity.onBackPressed()
            }

            secondaryMenuNewGameImgBtn.setOnClickListener {
                if (contextActivity.presenter.getCheckSound()) {
                    contextActivity.startSound()
                }
                contextActivity.presenter.setOpenListCard(InfoForContinue(ArrayList()))
                contextActivity.presenter.setQuantityOpenCard(0)
                when (contextActivity.presenter.getNumCard()) {
                    8 -> findNavController().navigate(R.id.action_secondaryMenuFragment_to_mainTwoEightCardsFragment)
                    10 -> findNavController().navigate(R.id.action_secondaryMenuFragment_to_mainTwoTenCardsFragment)
                    12 -> findNavController().navigate(R.id.action_secondaryMenuFragment_to_mainTwoTwelveCardsFragment)
                    else -> findNavController().navigate(R.id.action_secondaryMenuFragment_to_mainTwoSixCardsFragment)
                }
            }
            secondaryMenuKeepOnImgBtn.setOnClickListener {
                if (contextActivity.presenter.getCheckSound()) {
                    contextActivity.startSound()
                }
                when (contextActivity.presenter.getNumCard()) {
                    8 -> findNavController().navigate(R.id.action_secondaryMenuFragment_to_mainTwoEightCardsFragment)
                    10 -> findNavController().navigate(R.id.action_secondaryMenuFragment_to_mainTwoTenCardsFragment)
                    12 -> findNavController().navigate(R.id.action_secondaryMenuFragment_to_mainTwoTwelveCardsFragment)
                    else -> findNavController().navigate(R.id.action_secondaryMenuFragment_to_mainTwoSixCardsFragment)
                }
            }
        }
    }
}