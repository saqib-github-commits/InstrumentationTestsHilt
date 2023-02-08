package com.example.instrumentationTestsHilt.repository

import com.example.instrumentationTestsHilt.models.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ArticlesRepositoryImpl @Inject constructor(): ArticlesRepository {

    override suspend fun getArticles(): Flow<List<Article>> = flow {
        emit(listOf(
            Article("category1", "title1", "subtitle1"),
            Article("category1", "title1", "subtitle1"),
            Article("category1", "title1", "subtitle1")
        ))
    }

}