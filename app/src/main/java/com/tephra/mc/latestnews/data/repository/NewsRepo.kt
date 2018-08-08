package com.tephra.mc.latestnews.data.repository

import com.tephra.mc.latestnews.data.model.News
import javax.inject.Inject

/**
 * News Repository module, responsible for handling the news data operations
 */
class NewsRepo @Inject constructor(private val newsApiService: NewsApiService) {

    suspend fun getTopHeadlines(): Resource<News> {
        return try {
            val response = newsApiService.getTopHeadlines()
            val result = response.await()
            Resource.success(result)
        } catch (e: Throwable) {
            Resource.error(e.message!!, data = null)
        }
    }

}