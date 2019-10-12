package sample.qiitaclient


import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Matcher
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import rx.Observable
import sample.qiitaclient.client.ArticleClient

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun 各ビューが表示されていること_ただしプログレスバーは非表示() {
        onView(withId(R.id.list_view)).check(matches(isDisplayed()))
        onView(withId(R.id.query_edit_text)).check(matches(isDisplayed()))
        onView(withId(R.id.search_button)).check(matches(isDisplayed()))

        onView(withId(R.id.progress_bar)).check(matches(isNotDisplayed()))
    }

    @Test
    fun `検索ボタンがタップされたら、入力されたクエリ文字列で記事検索APIを叩くこと`() {
        val articleClient = mock(ArticleClient::class.java).apply {
            `when`(search("user:ngsw_taro")).thenReturn(Observable.just(listOf()))
        }
        activityTestRule.activity.articleClient = articleClient

        onView(withId(R.id.query_edit_text)).perform(typeText("user:ngsw_taro"))
        onView(withId(R.id.search_button)).perform(click())

        verify(articleClient).search("user:ngsw_taro")
    }

    private fun isNotDisplayed(): Matcher<View> = not(isDisplayed())
}
