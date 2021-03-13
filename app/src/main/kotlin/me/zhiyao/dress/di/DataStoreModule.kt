package me.zhiyao.dress.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.createDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *
 * @author WangZhiYao
 * @date 2021/1/25
 */
@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    private const val DATA_STORE_NAME = "Wedding"

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext appContext: Context): DataStore<Preferences> =
        appContext.createDataStore(DATA_STORE_NAME)
}