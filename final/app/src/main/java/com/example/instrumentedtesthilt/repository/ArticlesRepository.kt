package com.example.instrumentedtesthilt.repository

import com.example.instrumentedtesthilt.models.Article
import kotlinx.coroutines.flow.Flow

interface ArticlesRepository {

    fun getArticles(): Flow<List<Article>>

}