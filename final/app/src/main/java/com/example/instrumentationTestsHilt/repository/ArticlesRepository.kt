package com.example.instrumentationTestsHilt.repository

import com.example.instrumentationTestsHilt.models.Article
import kotlinx.coroutines.flow.Flow

interface ArticlesRepository {

    fun getArticles(): Flow<List<Article>>

}