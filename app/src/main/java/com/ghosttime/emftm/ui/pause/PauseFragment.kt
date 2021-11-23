package com.ghosttime.emftm.ui.pause

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ghosttime.emftm.R
import com.ghosttime.emftm.databinding.FragmentPauseBinding
import com.ghosttime.emftm.ui.main.MainActivity

class PauseFragment : Fragment() {

    private lateinit var viewBinding: FragmentPauseBinding
    private val contextActivity: MainActivity by lazy(LazyThreadSafetyMode.NONE) {
        (activity as MainActivity)
    }

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contextActivity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        return inflater.inflate(R.layout.fragment_pause, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentPauseBinding.bind(view)

        with(viewBinding) {
            if (contextActivity.presenter.getCheckSound()) {
                contextActivity.startSound()
            }
            pauseContinueImgBtn.setOnClickListener {
                when (contextActivity.presenter.getNumCard()) {
                    8 -> findNavController().navigate(R.id.action_pauseFragment_to_mainTwoEightCardsFragment)
                    10 -> findNavController().navigate(R.id.action_pauseFragment_to_mainTwoTenCardsFragment)
                    12 -> findNavController().navigate(R.id.action_pauseFragment_to_mainTwoTwelveCardsFragment)
                    else -> findNavController().navigate(R.id.action_pauseFragment_to_mainTwoSixCardsFragment)
                }
            }
            pauseMenuImgBtn.setOnClickListener {
                if (contextActivity.presenter.getCheckSound()) {
                    contextActivity.startSound()
                }
                findNavController().navigate(R.id.action_pauseFragment_to_menuFragment)
            }
        }
    }
}