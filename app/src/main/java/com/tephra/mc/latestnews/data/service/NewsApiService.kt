package com.tephra.mc.latestnews.data.repository


import com.tephra.mc.latestnews.BuildConfig
import com.tephra.mc.latestnews.data.model.News
import io.reactivex.Observable
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * REST API endpoints
 */
interface NewsApiService {

    @GET("/v2/top-headlines")
    fun getTopHeadlines(@Header("Authorization") api: String = BuildConfig.NEWS_API_KEY,
                        @Query("sources") query: String= "bbc-news",
                        @Query("language") language: String = "en",
                        @Query("sortby") sortBy: String = "publishedAt"): Deferred<News>
}