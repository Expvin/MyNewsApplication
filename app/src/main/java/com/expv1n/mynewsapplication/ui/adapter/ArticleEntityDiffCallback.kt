package com.expv1n.mynewsapplication.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.expv1n.mynewsapplication.data.database.ArticleEntity

class ArticleEntityDiffCallback: DiffUtil.ItemCallback<ArticleEntity>()  {
    override fun areItemsTheSame(oldItem: ArticleEntity, newItem: ArticleEntity): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ArticleEntity, newItem: ArticleEntity): Boolean {
        return oldItem == newItem
    }
}