package com.example.instrumentedtesthilt.di

import com.example.instrumentedtesthilt.data.FakeArticlesRepositoryImpl
import com.example.instrumentedtesthilt.repository.ArticlesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RepositoryModule::class]
)
abstract class RepositoryTestModule {

    @Singleton
    @Binds
    abstract fun bindsFakeArticlesRepository(fakeArticlesRepositoryImpl: FakeArticlesRepositoryImpl): ArticlesRepository

}