package sample.qiitaclient

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import sample.qiitaclient.model.Article
import sample.qiitaclient.view.ArticleView

class ArticleListAdapter(private val context: Context) : BaseAdapter() {
    var articles: List<Article> = emptyList()
    override fun getCount(): Int = articles.size
    override fun getItem(p0: Int): Any = articles[p0]
    override fun getItemId(p0: Int): Long = 0
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View =
        ((p1 as? ArticleView) ?: ArticleView(context)).apply {
            setArticle(articles[p0])
        }
}
