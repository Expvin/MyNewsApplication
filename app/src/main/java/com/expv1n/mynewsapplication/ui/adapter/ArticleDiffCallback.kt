package com.expv1n.mynewsapplication.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.expv1n.mynewsapplication.data.models.Article

class ArticleDiffCallback(): DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }

}