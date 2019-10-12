package sample.qiitaclient.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import androidx.databinding.DataBindingUtil
import sample.qiitaclient.R
import sample.qiitaclient.databinding.ViewArticleBinding
import sample.qiitaclient.model.Article

@BindingMethods(BindingMethod(type = Article::class,
    attribute = "app:article",
    method = "setArticle"))
class ArticleView : FrameLayout {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val binding: ViewArticleBinding =
        DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.view_article, this, true)

    fun setArticle(article: Article) {
        binding.article = article
    }
}
