package com.ghosttime.emftm.ui.menu

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ghosttime.emftm.R
import com.ghosttime.emftm.databinding.FragmentMenuBinding
import com.ghosttime.emftm.ui.main.MainActivity
import com.ghosttime.emftm.ui.main_two.InfoForContinue


class MenuFragment : Fragment() {

    private lateinit var viewBinding: FragmentMenuBinding
    private val contextActivity: MainActivity by lazy(LazyThreadSafetyMode.NONE) {
        (activity as MainActivity)
    }

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contextActivity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentMenuBinding.bind(view)

        with(viewBinding) {
            menuGameImgBtn.setOnClickListener {
                if (contextActivity.presenter.getCheckSound()) {
                    contextActivity.startSound()
                }
                findNavController().navigate(R.id.action_menuFragment_to_secondaryMenuFragment)
            }
            menuSetImgBtn.setOnClickListener {
                if (contextActivity.presenter.getCheckSound()) {
                    contextActivity.startSound()
                }
                findNavController().navigate(R.id.action_menuFragment_to_optionFragment)
            }
        }
    }
}