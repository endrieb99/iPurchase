package com.scally_p.ipurchase.ui.intro

import androidx.lifecycle.ViewModel
import com.scally_p.ipurchase.R
import com.scally_p.ipurchase.model.onboarding.OnBoardingItem
import org.koin.core.component.KoinComponent

class OnBoardingViewModel : ViewModel(), KoinComponent {

    private val tag: String = OnBoardingViewModel::class.java.name

    val onBoardingItems: ArrayList<OnBoardingItem>
        get() {
            val onBoardingItems: ArrayList<OnBoardingItem> = ArrayList()

            //Images
            val image1 = R.drawable.ic_on_boarding_1
            val image2 = R.drawable.ic_on_boarding_2
            val image3 = R.drawable.ic_on_boarding_3

            //Titles
            val title1 = R.string.title_1
            val title2 = R.string.title_2
            val title3 = R.string.title_3

            //Descriptions
            val description1 = R.string.description_1
            val description2 = R.string.description_2
            val description3 = R.string.description_3

            onBoardingItems.add(OnBoardingItem(image1, title1, description1))
            onBoardingItems.add(OnBoardingItem(image2, title2, description2))
            onBoardingItems.add(OnBoardingItem(image3, title3, description3))

            return onBoardingItems
        }
}