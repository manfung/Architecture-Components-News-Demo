package com.tephra.mc.latestnews.ui.topheadlines

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import app.news.mc.com.newsapp.ui.adapter.TopHeadlinesAdapter
import com.tephra.mc.latestnews.R
import com.tephra.mc.latestnews.data.repository.Resource
import com.tephra.mc.latestnews.data.repository.Status
import com.tephra.mc.latestnews.data.model.Article
import com.tephra.mc.latestnews.data.model.News
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.top_headlines_activity.*
import javax.inject.Inject

class TopHeadlinesActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var topHeadlinesViewModel: TopHeadlinesViewModel
    private lateinit var listView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.top_headlines_activity)
        setupViewModel()
        initViews()
        getTopHeadlines()

    }

    private fun setupViewModel() {

        topHeadlinesViewModel = ViewModelProviders.of(this, viewModelFactory)[TopHeadlinesViewModel::class.java]

        topHeadlinesViewModel.news.observe(this, Observer<Resource<News>> {
            updateUI(it!!)
        })
    }

    private fun updateUI(resource: Resource<News>) {

        when (resource.status) {

            Status.SUCCESS -> {
                updateList(resource.data!!.articles)
                swipeRefreshLayout.isRefreshing = false
            }

            Status.ERROR -> Toast.makeText(this, getString(R.string.top_headlines_load_error), Toast.LENGTH_SHORT).show()
        }
    }

    private fun initViews() {

        listView = recycler_list
        listView.layoutManager = LinearLayoutManager(this)
        swipeRefreshLayout = refreshLayoutTopHeadlines
        swipeRefreshLayout.setOnRefreshListener { getTopHeadlines() }
    }

    private fun getTopHeadlines() {

        topHeadlinesViewModel.getTopHeadlines()
    }

    private fun updateList(articles: List<Article>) {

        listView.adapter = TopHeadlinesAdapter(articles)
    }

}
