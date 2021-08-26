package com.jaidev.srijan.common

import android.content.Context
import androidx.annotation.StringRes
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


@Module
@InstallIn(ViewModelComponent::class)
class ResourceHelper @Inject constructor(@ApplicationContext val applicationContext: Context) {

    fun getString(@StringRes id: Int) = applicationContext.getString(id)


}
