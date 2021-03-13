package me.zhiyao.dress.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.io.File
import javax.inject.Singleton

/**
 *
 * @author WangZhiYao
 * @date 2021/1/25
 */
@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    private const val DATA_STORE_NAME = "dress"

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext appContext: Context): DataStore<Preferences> =
        PreferenceDataStoreFactory.create {
            File(
                appContext.filesDir, "datastore/$DATA_STORE_NAME.preferences_pb"
            )
        }
}