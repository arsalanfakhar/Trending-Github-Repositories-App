package com.sadapay.trendinggitrepo.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.jakewharton.rxbinding4.view.clicks
import com.sadapay.trendinggitrepo.databinding.ActivityMainBinding
import com.sadapay.trendinggitrepo.utils.ConnectionLiveData
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //Setup
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val disposeBag: CompositeDisposable by lazy { CompositeDisposable() }
    private lateinit var connectionLiveData: ConnectionLiveData
    private lateinit var trendingRepoAdapter: TrendingRepoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        connectionLiveData = ConnectionLiveData(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun initializeViews() {

        //Retry
        binding.retryButton.clicks()
            .throttleFirst(1, TimeUnit.SECONDS)
            .subscribe {
                retryFetching()
            }.addTo(disposeBag)


        //Observe network State
        connectionLiveData.observe(this, { isNetworkAvailable ->
            if (!isNetworkAvailable) {
                showRetryLayout()
            }
        })


    }


    private fun setupRecyclerView() {
        trendingRepoAdapter = TrendingRepoAdapter()

        binding.trendingRepoListView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = trendingRepoAdapter
            itemAnimator = null
        }
    }

    private fun bindViewModel() {
        viewModel.isLoading.subscribe {
            if (it) {
                binding.retryLayout.visibility = View.GONE
                binding.shimmerLayout.startShimmer()
                binding.shimmerLayout.visibility = View.VISIBLE
                binding.trendingRepoListView.visibility = View.GONE
            } else {
                binding.shimmerLayout.stopShimmer()
                binding.shimmerLayout.visibility = View.GONE
                binding.trendingRepoListView.visibility = View.VISIBLE
            }

        }.addTo(disposeBag)

        //Set data to adapter
        viewModel.mTrendingGitRepository.subscribe {
            trendingRepoAdapter.submitList(it)
        }.addTo(disposeBag)


        viewModel.apiError.subscribe {
            if (it) {
                showRetryLayout()
            }
        }.addTo(disposeBag)
    }

    private fun init() {
        setupRecyclerView()
        initializeViews()
        bindViewModel()
    }


    /*
        Helper functions
     */

    private fun retryFetching() {
        binding.retryLayout.visibility = View.GONE
        viewModel.fetchTrendingGitRepositories()
    }

    private fun showRetryLayout() {
        binding.shimmerLayout.visibility = View.INVISIBLE
        binding.trendingRepoListView.visibility = View.GONE
        binding.retryLayout.visibility = View.VISIBLE
        binding.retryLottie.playAnimation()
    }


    /*
     Overides
     */

    override fun onDestroy() {
        super.onDestroy()
        disposeBag.dispose()
    }
}