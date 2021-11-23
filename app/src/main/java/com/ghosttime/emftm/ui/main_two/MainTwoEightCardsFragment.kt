package com.ghosttime.emftm.ui.main_two

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ghosttime.emftm.R
import com.ghosttime.emftm.databinding.FragmentMainTwoEightCardsBinding
import com.ghosttime.emftm.ui.main.MainActivity

class MainTwoEightCardsFragment : Fragment() {

    private lateinit var viewBinding: FragmentMainTwoEightCardsBinding
    private val contextActivity: MainActivity by lazy(LazyThreadSafetyMode.NONE) {
        (activity as MainActivity)
    }
    private var openCard: Int = 0
    private lateinit var openImgBtn: ImageButton
    private var checkOpen: Boolean = false
    private lateinit var handler: Handler
    private val looper = Looper.myLooper()
    private var runnable = Runnable {}
    private var quantityOpenCard = 0
    private var isClickable = true
    private lateinit var randomListCard: ArrayList<Int>
    private lateinit var cardsForSave: ArrayList<Card>
    private var openListCardNow: ImageButton? = null
    private var isNeedSave = false

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contextActivity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        return inflater.inflate(R.layout.fragment_main_two_eight_cards, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentMainTwoEightCardsBinding.bind(view)

        if (looper != null) {
            handler = Handler(looper)
        }
        quantityOpenCard = contextActivity.presenter.getQuantityOpenCard()

        with(viewBinding) {

            mainTwoEightCardsBackImgBtn.setOnClickListener {
                if (contextActivity.presenter.getCheckSound()) {
                    contextActivity.startSound()
                }

                isNeedSave = true
                contextActivity.onBackPressed()
            }

            mainTwoEightCardsPauseImgBtn.setOnClickListener {
                if (contextActivity.presenter.getCheckSound()) {
                    contextActivity.startSound()
                }

                isNeedSave = true
                    findNavController().navigate(R.id.action_mainTwoEightCardsFragment_to_pauseFragment)
            }

            val primordialListCard = arrayListOf(
                R.drawable.ic_main_two_card_1,
                R.drawable.ic_main_two_card_2,
                R.drawable.ic_main_two_card_3,
                R.drawable.ic_main_two_card_4,
                R.drawable.ic_main_two_card_6,
                R.drawable.ic_main_two_card_7,
                R.drawable.ic_main_two_card_8,
                R.drawable.ic_main_two_card_9,
            )

            if (contextActivity.presenter.getOpenListCard().cards.isEmpty()) {

                randomListCard = arrayListOf(
                    primordialListCard.random(),
                    primordialListCard.random(),
                    primordialListCard.random(),
                    primordialListCard.random()
                )

                var set: HashSet<Int> = HashSet(randomListCard)

                randomListCard.clear()
                randomListCard.addAll(set)

                while (randomListCard.size < MAXIMUM_PAIRS_OF_PICTURES) {
                    randomListCard.add(primordialListCard.random())
                    set = HashSet(randomListCard)
                    randomListCard.clear()
                    randomListCard.addAll(set)
                }

                for (count in 0 until MAXIMUM_PAIRS_OF_PICTURES) {
                    randomListCard.add(randomListCard[count])
                }

                randomListCard.shuffle()
                cardsForSave = ArrayList()

                randomListCard.forEachIndexed { index, item ->
                    cardsForSave.add(Card(false, item, index))
                }
            } else {
                randomListCard = arrayListOf()
                cardsForSave = ArrayList(contextActivity.presenter.getOpenListCard().cards)

                contextActivity.presenter.getOpenListCard().cards.forEach { card ->
                    randomListCard.add(card.place, card.image)
                    if (card.isOpened) {
                        when (card.place) {
                            0 -> mainTwoEightCardsCard1.setBackgroundResource(card.image)
                            1 -> mainTwoEightCardsCard2.setBackgroundResource(card.image)
                            2 -> mainTwoEightCardsCard3.setBackgroundResource(card.image)
                            3 -> mainTwoEightCardsCard4.setBackgroundResource(card.image)
                            4 -> mainTwoEightCardsCard5.setBackgroundResource(card.image)
                            5 -> mainTwoEightCardsCard6.setBackgroundResource(card.image)
                            6 -> mainTwoEightCardsCard7.setBackgroundResource(card.image)
                            7 -> mainTwoEightCardsCard8.setBackgroundResource(card.image)
                            else -> {
                            }
                        }
                    }
                }
            }

            mainTwoEightCardsCard1.setOnClickListener {
                if (isClickable) {
                    mainAction(mainTwoEightCardsCard1, randomListCard[0])
                }
                openListCardNow = mainTwoEightCardsCard1
            }

            mainTwoEightCardsCard2.setOnClickListener {
                if (isClickable) {
                    mainAction(mainTwoEightCardsCard2, randomListCard[1])
                }
                openListCardNow = mainTwoEightCardsCard2
            }

            mainTwoEightCardsCard3.setOnClickListener {
                if (isClickable) {
                    mainAction(mainTwoEightCardsCard3, randomListCard[2])
                }
                openListCardNow = mainTwoEightCardsCard3
            }

            mainTwoEightCardsCard4.setOnClickListener {
                if (isClickable) {
                    mainAction(mainTwoEightCardsCard4, randomListCard[3])
                }
                openListCardNow = mainTwoEightCardsCard4
            }

            mainTwoEightCardsCard5.setOnClickListener {
                if (isClickable) {
                    mainAction(mainTwoEightCardsCard5, randomListCard[4])
                }
                openListCardNow = mainTwoEightCardsCard5
            }

            mainTwoEightCardsCard6.setOnClickListener {
                if (isClickable) {
                    mainAction(mainTwoEightCardsCard6, randomListCard[5])
                }
                openListCardNow = mainTwoEightCardsCard6
            }

            mainTwoEightCardsCard7.setOnClickListener {
                if (isClickable) {
                    mainAction(mainTwoEightCardsCard7, randomListCard[6])
                }
                openListCardNow = mainTwoEightCardsCard7
            }

            mainTwoEightCardsCard8.setOnClickListener {
                if (isClickable) {
                    mainAction(mainTwoEightCardsCard8, randomListCard[7])
                }
                openListCardNow = mainTwoEightCardsCard8
            }
        }
    }

    private fun mainAction(card: ImageButton, picture: Int) {
        if (openListCardNow == null || openListCardNow != card) {
            card.setBackgroundResource(picture)
            isClickable = false

            if (checkOpen) {
                checkOpen = if (openCard != picture) {
                    card.setBackgroundResource(picture)

                    runnable = Runnable {
                        isClickable = false
                        openImgBtn.setBackgroundResource(R.drawable.ic_main_two_card_back)
                        card.setBackgroundResource(R.drawable.ic_main_two_card_back)
                        isClickable = true
                        openListCardNow = null
                    }

                    handler.postDelayed(runnable, DELAYED_ANIMATION)

                    false
                } else {
                    card.isClickable = false
                    openImgBtn.isClickable = false

                    quantityOpenCard++
                    contextActivity.presenter.setQuantityOpenCard(quantityOpenCard)

                    cardsForSave.forEach {
                        if (it.image == picture) {
                            it.isOpened = true
                        }
                        if (quantityOpenCard == MAXIMUM_PAIRS_OF_PICTURES) {
                            it.isOpened = false
                        }
                    }

                    if (quantityOpenCard == MAXIMUM_PAIRS_OF_PICTURES) {
                        isNeedSave = false
                        card.setBackgroundResource(picture)
                        quantityOpenCard = 0
                        contextActivity.presenter.setQuantityOpenCard(quantityOpenCard)

                        runnable = Runnable {
                            val ft = requireFragmentManager().beginTransaction()
                            if (Build.VERSION.SDK_INT >= VERSION_SDK) {
                                ft.setReorderingAllowed(false)
                            }
                            ft.detach(this).attach(this)
                                .commit()
                            isClickable = true
                        }

                        handler.postDelayed(runnable, DELAYED_ANIMATION)
                        contextActivity.presenter.setOpenListCard(InfoForContinue(ArrayList()))
                    }

                    openListCardNow = null
                    isClickable = true

                    false
                }
            } else {
                isClickable = true
                openCard = picture
                openImgBtn = card
                checkOpen = true
            }
        }
    }

    override fun onStop() {
        if (isNeedSave) {
            contextActivity.presenter.setOpenListCard(InfoForContinue(cardsForSave))
        }
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacks(runnable)
    }

    companion object{
        const val MAXIMUM_PAIRS_OF_PICTURES = 4
        const val DELAYED_ANIMATION = 1000L
        const val VERSION_SDK = 26
    }
}