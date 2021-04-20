package com.mohamed.news.app

import com.mohamed.news.BuildConfig
import com.mohamed.news.data.repository.NewsRepositoryImplementation
import com.mohamed.news.domain.repository.NewsRepository
import com.mohamed.news.domain.usecase.*
import com.mohamed.news.presentation.home.HomeViewModel
import com.mohamed.news.presentation.onboard.country.CountriesViewModel
import com.mohamed.news.presentation.onboard.interests.InterestsViewModel
import com.mohamed.news.presentation.splash.SplashViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val koinModule = module {

    single { provideRetrofit() }

    single { NewsRepositoryImplementation(get()) as NewsRepository }

    single { CheckFirstUse(get()) }

    single { GetNews(get(), get()) }

    viewModel { SplashViewModel(get()) }

    viewModel { CountriesViewModel() }

    viewModel { InterestsViewModel() }

    viewModel { HomeViewModel(get()) }
}

fun provideRetrofit(): Retrofit
{
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
    return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build()
}