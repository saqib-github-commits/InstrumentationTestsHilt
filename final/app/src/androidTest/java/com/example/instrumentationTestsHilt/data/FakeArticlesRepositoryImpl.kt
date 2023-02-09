package com.example.instrumentationTestsHilt.data

import com.example.instrumentationTestsHilt.models.Article
import com.example.instrumentationTestsHilt.repository.ArticlesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FakeArticlesRepositoryImpl @Inject constructor(): ArticlesRepository {

    override fun getArticles(): Flow<List<Article>> = flow {
        emit(listOf(
            Article("category1", "title1", "subtitle1"),
            Article("category2", "title2", "subtitle2"),
            Article("category3", "title3", "subtitle3")
        ))
    }

}