package me.zhiyao.dress.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.zhiyao.dress.data.db.dao.*
import me.zhiyao.dress.data.mapper.DressWithFilterMapper
import me.zhiyao.dress.data.mapper.FilterWithFilterOptionsMapper
import me.zhiyao.dress.data.repo.*
import javax.inject.Singleton

/**
 *
 * @author WangZhiYao
 * @date 2021/1/18
 */
@Module
@InstallIn(SingletonComponent::class)
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