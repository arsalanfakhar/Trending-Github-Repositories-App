package com.sadapay.trendinggitrepo.network.interfaces

import com.sadapay.trendinggitrepo.model.TrendingApiResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ITredingGitService {

    @GET("search/repositories")
    fun getTrendingRepositories(
        @Query("q") query: String = "language=+sort:stars"
    ): Flowable<TrendingApiResponse>


}