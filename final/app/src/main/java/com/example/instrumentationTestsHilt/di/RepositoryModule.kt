package com.example.instrumentationTestsHilt.di

import com.example.instrumentationTestsHilt.repository.ArticlesRepository
import com.example.instrumentationTestsHilt.repository.ArticlesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    internal abstract fun bindArticlesRepository(articlesRepositoryImpl: ArticlesRepositoryImpl): ArticlesRepository

}