package com.example.instrumentedtesthilt.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instrumentedtesthilt.models.Article
import com.example.instrumentedtesthilt.repository.ArticlesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val articlesRepository: ArticlesRepository
) : ViewModel() {

    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    val articles = _articles.asStateFlow()

    init {
        viewModelScope.launch {
            articlesRepository.getArticles()
                .catch { /* Error case */}
                .collect { _articles.value = it }
        }
    }

}