package sample.qiitaclient

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import sample.qiitaclient.model.Article
import sample.qiitaclient.model.User

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listAdapter = ArticleListAdapter(applicationContext)
        listAdapter.articles =
            listOf(dummyArticle("Kotlin入門", "たろう"), dummyArticle("Java入門", "じろう"))

        val listView: ListView = findViewById(R.id.list_view)
        listView.adapter = listAdapter
        listView.setOnItemClickListener { _, _, i, _ ->
            val article = listAdapter.articles[i]
            startActivity(ArticleActivity.intent(this, article))
        }
    }

    private fun dummyArticle(title: String, userName: String): Article =
        Article("", title, "https://kotlinlang.org/", User("", userName, ""))
}
