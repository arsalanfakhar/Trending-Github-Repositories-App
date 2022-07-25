package com.sadapay.trendinggitrepo.model

data class TrendingRepoListMap(
    var id: Int,
    var repoUserImage: String,
    var repoUserName: String,
    var repoName: String,
    var repoDescription: String = "",
    var repoLanguages: List<String>,
    var repoStarCount: Int = 0,
    var isExpanded: Boolean = false
)