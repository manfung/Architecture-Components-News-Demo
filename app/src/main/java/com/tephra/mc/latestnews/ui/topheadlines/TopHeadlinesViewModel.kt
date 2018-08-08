package com.tephra.mc.latestnews.ui.topheadlines

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tephra.mc.latestnews.data.repository.Resource
import com.tephra.mc.latestnews.data.model.News
import com.tephra.mc.latestnews.data.repository.NewsRepo
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class TopHeadlinesViewModel @Inject constructor(private val newsRepository: NewsRepo): ViewModel() {

    val news: MutableLiveData<Resource<News>> = MutableLiveData()

    fun getTopHeadlines() {

        launch(CommonPool) {
            val response = newsRepository.getTopHeadlines()
            news.postValue(response)
        }
    }

}
