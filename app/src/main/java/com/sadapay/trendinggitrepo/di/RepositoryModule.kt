package com.sadapay.trendinggitrepo.di

import com.sadapay.trendinggitrepo.network.interfaces.ITredingGitService
import com.sadapay.trendinggitrepo.repository.TrendingGitRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideTrendingGirRepository(
        gitService: ITredingGitService
    ): TrendingGitRepository {
        return TrendingGitRepository(gitService)
    }

}