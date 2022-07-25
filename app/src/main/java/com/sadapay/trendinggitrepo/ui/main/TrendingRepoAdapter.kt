package com.sadapay.trendinggitrepo.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sadapay.trendinggitrepo.databinding.TrendingListViewBinding
import com.sadapay.trendinggitrepo.model.TrendingRepoListMap

class TrendingRepoAdapter(
) : ListAdapter<TrendingRepoListMap, TrendingRepoAdapter.TrendingRepoViewHolder>(
    TrendingRepoDiffUtil()
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingRepoViewHolder {
        return TrendingRepoViewHolder(
            binding = TrendingListViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TrendingRepoViewHolder, position: Int) {
        val item = getItem(position)

        holder.bind(item)

        holder.viewLayout.setOnClickListener {

            //Toggle expanded state
            item.isExpanded = !item.isExpanded

            //Apply the changes to expand
            notifyItemChanged(position)
        }
    }


    class TrendingRepoViewHolder(
        private val binding: TrendingListViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        var viewLayout: ConstraintLayout = binding.root

        fun bind(item: TrendingRepoListMap) {

            binding.expandableLayout.visibility = if (item.isExpanded) View.VISIBLE else View.GONE

            //Set data
            Glide.with(binding.root)
                .load(item.repoUserImage)
                .into(binding.tredingRepoListImage)

            binding.tredingRepoListUserName.text = item.repoUserName
            binding.tredingRepoListRepoName.text = item.repoName
            binding.tredingRepoListDescription.text = item.repoDescription

            binding.tredingRepoStarCount.text = item.repoStarCount.toString()
            binding.tredingRepoLanguageTxt.text =
                if (item.repoLanguages.isNotEmpty()) item.repoLanguages.first() else ""

        }
    }


    class TrendingRepoDiffUtil : DiffUtil.ItemCallback<TrendingRepoListMap>() {

        override fun areItemsTheSame(
            oldItem: TrendingRepoListMap,
            newItem: TrendingRepoListMap
        ): Boolean {
            return false
        }

        override fun areContentsTheSame(
            oldItem: TrendingRepoListMap,
            newItem: TrendingRepoListMap
        ): Boolean {
            return false
        }

    }


}