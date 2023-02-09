package com.example.instrumentationTestsHilt.di

import com.example.instrumentationTestsHilt.data.FakeArticlesRepositoryImpl
import com.example.instrumentationTestsHilt.repository.ArticlesRepository
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