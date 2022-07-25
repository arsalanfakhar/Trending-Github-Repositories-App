package com.sadapay.trendinggitrepo.ui.main

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.sadapay.trendinggitrepo.model.TrendingApiResponse
import com.sadapay.trendinggitrepo.model.TrendingRepoListMap
import com.sadapay.trendinggitrepo.repository.TrendingGitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.subjects.BehaviorSubject
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: TrendingGitRepository
) : ViewModel() {

    //Setup
    private val disposeBag: CompositeDisposable by lazy { CompositeDisposable() }

    private val _isLoading: BehaviorSubject<Boolean> = BehaviorSubject.create()
    private val _apiError: BehaviorSubject<Boolean> = BehaviorSubject.create()
    private val _trendingGitRepositoryList: BehaviorSubject<List<TrendingRepoListMap>> =
        BehaviorSubject.create()

    val isLoading: Observable<Boolean> = _isLoading;
    val apiError: Observable<Boolean> = _apiError
    val mTrendingGitRepository: Observable<List<TrendingRepoListMap>> =
        _trendingGitRepositoryList

    init {
        fetchTrendingGitRepositories()
    }

    public fun fetchTrendingGitRepositories() {
        _isLoading.onNext(true)
        repository.getTrendingGitRepositories().subscribe({
            _isLoading.onNext(false)

            if (it.items?.isEmpty() == true) {
                _trendingGitRepositoryList.onNext(arrayListOf())
            } else {

                //Also get languages


                val repoListMap: List<TrendingRepoListMap>? = it.items?.map { item ->
                    return@map TrendingRepoListMap(
                        item.id!!,
                        item.owner.avatar_url!!,
                        item.owner.login!!,
                        item.name!!,
                        item.description!!,
                        item.topics ?: arrayListOf(),
                        item.stargazers_count!!
                    )
                }

                _trendingGitRepositoryList.onNext(repoListMap!!)
            }


        }, {
            _isLoading.onNext(false)
            _apiError.onNext(true)
            Log.v("Data Error", it.message.toString())

        }).addTo(disposeBag)

    }

    override fun onCleared() {
        super.onCleared()
        disposeBag.dispose()
    }
}