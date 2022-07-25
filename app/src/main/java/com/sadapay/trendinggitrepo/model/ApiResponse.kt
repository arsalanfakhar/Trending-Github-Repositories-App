package com.sadapay.trendinggitrepo.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class TrendingApiResponse {
    @Json(name = "total_count")
    var total_count: Int = 0

    @Json(name = "incomplete_results")
    var incomplete_results: Boolean = false

    @Json(name = "items")
    var items: ArrayList<Items>? = arrayListOf();


    @JsonClass(generateAdapter = true)
    data class Items(

        @Json(name = "node_id") var node_id: String?,
        @Json(name = "id") var id: Int?,
        @Json(name = "name") var name: String?,
        @Json(name = "full_name") var full_name: String?,
        @Json(name = "private") var private: Boolean?,
        @Json(name = "owner") var owner: Owner,
        @Json(name = "html_url") var html_url: String?,
        @Json(name = "description") var description: String?,
        @Json(name = "fork") var fork: Boolean?,
        @Json(name = "url") var url: String?,
        @Json(name = "forks_url") var forks_url: String?,
        @Json(name = "keys_url") var keys_urls_url: String?,
        @Json(name = "collaborators_url") var collaborators_url: String?,
        @Json(name = "teams_url") var teams_url: String?,
        @Json(name = "hooks_url") var hooks_url: String?,
        @Json(name = "issue_events_url") var issue_events_url: String?,
        @Json(name = "events_url") var events_url: String?,
        @Json(name = "assignees_url") var assignees_url: String?,
        @Json(name = "branches_url") var branches_url: String?,
        @Json(name = "tags_url") var tags_url: String?,
        @Json(name = "blobs_url") var blobs_url: String?,
        @Json(name = "git_tags_url") var git_tags_url: String?,
        @Json(name = "git_refs_url") var git_refs_url: String?,
        @Json(name = "trees_url") var trees_url: String?,
        @Json(name = "statuses_url") var statuses_url: String?,
        @Json(name = "languages_url") var languages_url: String?,
        @Json(name = "stargazers_url") var stargazers_url: String?,
        @Json(name = "contributors_url") var contributors_url: String?,
        @Json(name = "subscribers_url") var subscribers_url: String?,
        @Json(name = "subscription_url") var subscription_url: String?,
        @Json(name = "commits_url") var commits_url: String?,
        @Json(name = "git_commits_url") var git_commits_url: String?,
        @Json(name = "comments_url") var comments_url: String?,
        @Json(name = "issue_comment_url") var issue_comment_url: String?,
        @Json(name = "contents_url") var contents_url: String?,
        @Json(name = "compare_url") var compare_url: String?,
        @Json(name = "merges_url") var merges_url: String?,
        @Json(name = "archive_url") var archive_url: String?,
        @Json(name = "downloads_url") var downloads_url: String?,
        @Json(name = "issues_url") var issues_url: String?,
        @Json(name = "pulls_url") var pulls_url: String?,
        @Json(name = "milestones_url") var milestones_url: String?,
        @Json(name = "notifications_url") var notifications_url: String?,
        @Json(name = "labels_url") var labels_url: String?,
        @Json(name = "releases_url") var releases_url: String?,
        @Json(name = "deployments_url") var deployments_url: String?,
        @Json(name = "created_at") var created_at: String?,
        @Json(name = "updated_at") var updated_at: String?,
        @Json(name = "pushed_at") var pushed_at: String?,
        @Json(name = "git_url") var git_url: String?,
        @Json(name = "ssh_url") var ssh_url: String?,
        @Json(name = "clone_url") var clone_url: String?,
        @Json(name = "svn_url") var svn_url: String?,
        @Json(name = "homepage") var homepage: String?,
        @Json(name = "size") var size: Int?,
        @Json(name = "stargazers_count") var stargazers_count: Int?,
        @Json(name = "watchers_count") var watchers_count: Int?,
        @Json(name = "language") var language: String?,
        @Json(name = "has_issues") var has_issues: Boolean?,
        @Json(name = "has_projects") var has_projects: Boolean?,
        @Json(name = "has_downloads") var has_downloads: Boolean?,
        @Json(name = "has_wiki") var has_wiki: Boolean?,
        @Json(name = "has_pages") var has_pages: Boolean?,
        @Json(name = "forks_count") var forks_count: Int?,
        @Json(name = "archived") var archived: Boolean?,
        @Json(name = "disabled") var disabled: Boolean?,
        @Json(name = "open_issues_count") var open_issues_count: Int?,
        @Json(name = "allow_forking") var allow_forking: Boolean?,
        @Json(name = "is_template") var is_template: Boolean?,
        @Json(name = "topics") var topics: List<String>?,
        @Json(name = "visibility") var visibility: String?,
        @Json(name = "forks") var forks: Int?,
        @Json(name = "open_issues") var open_issues: Int?,
        @Json(name = "watchers") var watchers: Int?,
        @Json(name = "default_branch") var default_branch: String?,
        @Json(name = "score") var score: Int?
    )

    @JsonClass(generateAdapter = true)
    data class Owner(

        @Json(name = "login") var login: String?,
        @Json(name = "id") var id: Int?,
        @Json(name = "node_id") var node_id: String?,
        @Json(name = "avatar_url") var avatar_url: String?,
        @Json(name = "gravatar_id") var gravatar_id: String?,
        @Json(name = "url") var url: String?,
        @Json(name = "html_url") var html_url: String?,
        @Json(name = "followers_url") var followers_url: String?,
        @Json(name = "following_url") var following_url: String?,
        @Json(name = "gists_url") var gists_url: String?,
        @Json(name = "starred_url") var starred_url: String?,
        @Json(name = "subscriptions_url") var subscriptions_url: String?,
        @Json(name = "organizations_url") var organizations_url: String?,
        @Json(name = "repos_url") var repos_url: String?,
        @Json(name = "events_url") var events_url: String?,
        @Json(name = "received_events_url") var received_events_url: String?,
        @Json(name = "type") var type: String?,
        @Json(name = "site_admin") var site_admin: Boolean?
    )


}

