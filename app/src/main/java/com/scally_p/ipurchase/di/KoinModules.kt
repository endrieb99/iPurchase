package com.scally_p.ipurchase.di

import com.scally_p.ipurchase.data.local.PrefsManager
import com.scally_p.ipurchase.ui.home.ProductsViewModel
import com.scally_p.ipurchase.ui.intro.OnBoardingViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun getModules(): List<Module> = listOf(
    prefsManagerModule,
    onBoardingViewModel,
    productsViewModel,
)

val prefsManagerModule = module { single { PrefsManager(androidApplication()) } }

//Db Helpers

//Repositories

//ViewModels
val onBoardingViewModel = module { viewModel { OnBoardingViewModel() } }
val productsViewModel = module { viewModel { ProductsViewModel() } }