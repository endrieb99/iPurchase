package com.scally_p.ipurchase.ui.intro

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewpager2.widget.ViewPager2
import com.scally_p.ipurchase.R
import com.scally_p.ipurchase.data.local.PrefsManager
import com.scally_p.ipurchase.databinding.ActivityIntroBinding
import com.scally_p.ipurchase.ui.home.MainActivity
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinComponent


class IntroActivity : AppCompatActivity(), View.OnClickListener, KoinComponent {

    private val tag: String = IntroActivity::class.java.name

    private lateinit var binding: ActivityIntroBinding
    private lateinit var adapter: OnBoardingAdapter

    private val prefsManager: PrefsManager by inject()
    private val viewModel: OnBoardingViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        if (prefsManager.onBoardingSeen) {
//            startActivity(Intent(this, MainActivity::class.java))
//            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
//            finish()
//        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                prepareViews()
                displayData()
            }
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.buttonAction -> {
                prefsManager.onBoardingSeen = true
                startActivity(Intent(applicationContext, MainActivity::class.java))
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                finish()
            }
        }
    }

    private fun prepareViews() {
        binding.buttonAction.setOnClickListener(this)
    }

    private fun displayData() {
        adapter = OnBoardingAdapter(viewModel.onBoardingItems)
        binding.viewPager.adapter = adapter
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.dotsIndicator.attachTo(binding.viewPager)
        binding.viewPager.currentItem = 0
    }
}