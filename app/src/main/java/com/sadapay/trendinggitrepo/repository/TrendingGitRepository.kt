package com.sadapay.trendinggitrepo.repository

import com.sadapay.trendinggitrepo.model.TrendingApiResponse
import com.sadapay.trendinggitrepo.network.interfaces.ITredingGitService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class TrendingGitRepository(
    private val gitService: ITredingGitService
) {

    private val disposeBag: CompositeDisposable by lazy { CompositeDisposable() }

    fun getTrendingGitRepositories(): Flowable<TrendingApiResponse> {
        val call = gitService.getTrendingRepositories()
        return call.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

}