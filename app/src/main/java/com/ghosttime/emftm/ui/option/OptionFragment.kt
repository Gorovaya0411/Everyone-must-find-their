package com.ghosttime.emftm.ui.option

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ghosttime.emftm.R
import com.ghosttime.emftm.databinding.FragmentOptionBinding
import com.ghosttime.emftm.ui.main.MainActivity


class OptionFragment : Fragment() {

    private lateinit var viewBinding: FragmentOptionBinding
    private val contextActivity: MainActivity by lazy(LazyThreadSafetyMode.NONE) {
        (activity as MainActivity)
    }

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contextActivity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        return inflater.inflate(R.layout.fragment_option, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentOptionBinding.bind(view)

        with(viewBinding) {

            with(contextActivity) {
                optionBackImgBtn.setOnClickListener {
                    if (contextActivity.presenter.getCheckSound()) {
                        contextActivity.startSound()
                    }
                    onBackPressed()
                }

                when (presenter.getNumCard()) {
                    8 -> animFor8NumCard()
                    10 -> animFor10NumCard()
                    12 -> animFor12NumCard()
                    else -> animFor6NumCard()
                }

                if (presenter.getCheckSound()) {
                    animForSoundOn()
                } else {
                    animForSoundOff()
                }

                optionNumCards6ImgBtn.setOnClickListener {
                    if (presenter.getCheckSound()) {
                        contextActivity.startSound()
                    }
                    presenter.setNumCard(6)
                    animFor6NumCard()
                }

                optionNumCards8ImgBtn.setOnClickListener {
                    if (presenter.getCheckSound()) {
                        contextActivity.startSound()
                    }
                    presenter.setNumCard(8)
                    animFor8NumCard()
                }

                optionNumCards10ImgBtn.setOnClickListener {
                    if (presenter.getCheckSound()) {
                        contextActivity.startSound()
                    }
                    presenter.setNumCard(10)
                    animFor10NumCard()
                }

                optionNumCards12ImgBtn.setOnClickListener {
                    if (presenter.getCheckSound()) {
                        contextActivity.startSound()
                    }
                    presenter.setNumCard(12)
                    animFor12NumCard()
                }

                optionSoundOnImgBtn.setOnClickListener {
                    if (presenter.getCheckSound()) {
                        contextActivity.startSound()
                    }
                    presenter.setCheckSound(true)
                    animForSoundOn()
                }

                optionSoundOffImgBtn.setOnClickListener {
                    if (contextActivity.presenter.getCheckSound()) {
                        contextActivity.startSound()
                    }
                    presenter.setCheckSound(false)
                    animForSoundOff()
                }
            }
        }
    }

    private fun animFor6NumCard() {
        with(viewBinding) {
            optionNumCards6ImgBtn.setBackgroundResource(R.drawable.bg_option_anime_6_num_card)
            optionNumCards8ImgBtn.setBackgroundResource(R.drawable.ic_option_num_card_8)
            optionNumCards10ImgBtn.setBackgroundResource(R.drawable.ic_option_num_card_10)
            optionNumCards12ImgBtn.setBackgroundResource(R.drawable.ic_option_num_card_12_top)
            (optionNumCards6ImgBtn.background as AnimationDrawable).also {
                it.isOneShot = false
            }.start()
        }
    }

    private fun animFor8NumCard() {
        with(viewBinding) {
            optionNumCards8ImgBtn.setBackgroundResource(R.drawable.bg_option_anime_8_num_card)
            optionNumCards6ImgBtn.setBackgroundResource(R.drawable.ic_option_num_card_6)
            optionNumCards10ImgBtn.setBackgroundResource(R.drawable.ic_option_num_card_10)
            optionNumCards12ImgBtn.setBackgroundResource(R.drawable.ic_option_num_card_12_top)
            (optionNumCards8ImgBtn.background as AnimationDrawable).also {
                it.isOneShot = false
            }.start()
        }
    }

    private fun animFor10NumCard() {
        with(viewBinding) {
            optionNumCards10ImgBtn.setBackgroundResource(R.drawable.bg_option_anime_10_num_card)
            optionNumCards8ImgBtn.setBackgroundResource(R.drawable.ic_option_num_card_8)
            optionNumCards6ImgBtn.setBackgroundResource(R.drawable.ic_option_num_card_6)
            optionNumCards12ImgBtn.setBackgroundResource(R.drawable.ic_option_num_card_12_top)
            (optionNumCards10ImgBtn.background as AnimationDrawable).also {
                it.isOneShot = false
            }.start()
        }
    }

    private fun animFor12NumCard() {
        with(viewBinding) {
            optionNumCards12ImgBtn.setBackgroundResource(R.drawable.bg_option_anime_12_num_card)
            optionNumCards8ImgBtn.setBackgroundResource(R.drawable.ic_option_num_card_8)
            optionNumCards10ImgBtn.setBackgroundResource(R.drawable.ic_option_num_card_10)
            optionNumCards6ImgBtn.setBackgroundResource(R.drawable.ic_option_num_card_6)
            (optionNumCards12ImgBtn.background as AnimationDrawable).also {
                it.isOneShot = false
            }.start()
        }
    }

    private fun animForSoundOn() {
        with(viewBinding) {
            optionSoundOnImgBtn.setBackgroundResource(R.drawable.bg_option_anime_sound_on)
            optionSoundOffImgBtn.setBackgroundResource(R.drawable.ic_option_sound_off_not_selected)
            (optionSoundOnImgBtn.background as AnimationDrawable).also {
                it.isOneShot = true
            }.start()
        }
    }

    private fun animForSoundOff() {
        with(viewBinding) {
            optionSoundOffImgBtn.setBackgroundResource(R.drawable.bg_option_anime_sound_off)
            optionSoundOnImgBtn.setBackgroundResource(R.drawable.ic_option_sound_on_not_selected)
            (optionSoundOffImgBtn.background as AnimationDrawable).also {
                it.isOneShot = true
            }.start()
        }
    }
}
