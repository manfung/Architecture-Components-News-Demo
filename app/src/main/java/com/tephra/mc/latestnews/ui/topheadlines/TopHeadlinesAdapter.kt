package app.news.mc.com.newsapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tephra.mc.latestnews.R
import com.tephra.mc.latestnews.data.model.Article
import kotlinx.android.synthetic.main.top_headlines_list_item.view.*
import java.text.SimpleDateFormat

class TopHeadlinesAdapter(private val articles: List<Article>) :
        RecyclerView.Adapter<TopHeadlinesAdapter.TopHeadlineItemViewHolder>() {

    class TopHeadlineItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val DATE_FORMAT = "dd/MM/yyy"

        fun bind(article: Article) {
            itemView.txt_title.text = article.title
            itemView.txt_description.text = article.description
            itemView.txt_published.text = SimpleDateFormat(DATE_FORMAT).format(article.publishedAt).toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): TopHeadlinesAdapter.TopHeadlineItemViewHolder {

        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.top_headlines_list_item, parent, false) as View

        return TopHeadlineItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TopHeadlineItemViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
    }

    override fun getItemCount() = articles.size

}
