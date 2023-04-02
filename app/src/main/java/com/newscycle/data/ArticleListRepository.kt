package com.newscycle.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava3.flowable
import com.newscycle.Feed
import com.newscycle.data.models.ArticleModel
import io.reactivex.rxjava3.core.Flowable

class ArticleListRepository(private val FEED_TAG: Feed) {

    fun getArticles(query: String, fromDate: String, sortBy: String): Flowable<PagingData<ArticleModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 10
            ),
            pagingSourceFactory = {
                ArticlePagingSource(query, sortBy, fromDate, FEED_TAG)
            }
        ).flowable
    }
}