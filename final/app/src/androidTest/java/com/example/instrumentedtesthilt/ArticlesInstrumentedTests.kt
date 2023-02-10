package com.example.instrumentedtesthilt

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.instrumentedtesthilt.composables.ArticlesScreen
import com.example.instrumentedtesthilt.repository.ArticlesRepository
import com.example.instrumentedtesthilt.ui.theme.InstrumentationTestsHiltTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class ArticlesInstrumentedTests {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Inject
    lateinit var articlesRepository: ArticlesRepository

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun articles_list_is_displayed_successfully() = runTest {

        composeTestRule.onNodeWithTag("testTagArticlesList").assertIsDisplayed()

        articlesRepository.getArticles().collectLatest { articles ->
            articles.forEach {
                composeTestRule.onNodeWithText(it.category).assertIsDisplayed()
                composeTestRule.onNodeWithText(it.title).assertIsDisplayed()
                composeTestRule.onNodeWithText(it.subtitle).assertIsDisplayed()
            }
        }

    }

}