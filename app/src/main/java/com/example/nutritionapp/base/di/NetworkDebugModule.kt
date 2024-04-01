package com.example.nutritionapp.base.di

import android.util.Log
import com.biot.core_network.interceptor.BaseUrlInterceptor
import com.biot.core_network.interceptor.LoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okio.Buffer
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkDebugModule {

    @IntoSet
    @Provides
    fun provideHttpLoggingInterceptor(): Interceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = Interceptor { chain ->
            val request = chain.request()
            Log.d("Request URL", request.url.toString())
            if (request.body != null) {
                val buffer = Buffer()
                request.body!!.writeTo(buffer)
                Log.d("Request Body", buffer.readUtf8())
            }
            chain.proceed(request)
        }
        val builder = OkHttpClient.Builder().addInterceptor(interceptor)
        return builder.build()
    }
}