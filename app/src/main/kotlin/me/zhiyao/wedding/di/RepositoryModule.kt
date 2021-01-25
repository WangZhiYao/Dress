package me.zhiyao.wedding.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import me.zhiyao.wedding.data.db.dao.*
import me.zhiyao.wedding.data.mapper.DressWithFilterMapper
import me.zhiyao.wedding.data.mapper.FilterWithFilterOptionsMapper
import me.zhiyao.wedding.data.repo.*
import javax.inject.Singleton

/**
 *
 * @author WangZhiYao
 * @date 2021/1/18
 */
@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideSettingRepository(dataStore: DataStore<Preferences>): SettingRepository =
        SettingRepository(dataStore)

    @Provides
    @Singleton
    fun provideDressRepository(dressDao: DressDao): DressRepository =
        DressRepository(dressDao, DressWithFilterMapper())

    @Provides
    @Singleton
    fun provideCustomerRepository(customerDao: CustomerDao): CustomerRepository =
        CustomerRepository(customerDao)

    @Provides
    @Singleton
    fun provideReserveRepository(reserveDao: ReserveDao): ReserveRepository =
        ReserveRepository(reserveDao)

    @Provides
    @Singleton
    fun provideFilterRepository(
        filterDao: FilterDao,
        filterOptionDao: FilterOptionDao
    ): FilterRepository =
        FilterRepository(filterDao, filterOptionDao, FilterWithFilterOptionsMapper())

}