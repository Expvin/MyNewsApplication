package com.expv1n.mynewsapplication.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.expv1n.mynewsapplication.R
import com.expv1n.mynewsapplication.data.models.Article

class MainScreenAdapter: ListAdapter<Article, MainScreenAdapter.MainScreenViewHolder>(ArticleDiffCallback())  {

    var onClickListener: ((Article) -> Unit)? = null

     class MainScreenViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val articleImageView = view.findViewById<ImageView>(R.id.itemArticleImageView)
        val favoriteImageView = view.findViewById<ImageView>(R.id.itemFavoriteImageView)
        val titileTextView = view.findViewById<TextView>(R.id.itemTitleTextView)
        val descriptionTextView = view.findViewById<TextView>(R.id.itemDescriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainScreenViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return MainScreenViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainScreenViewHolder, position: Int) {
        val article = getItem(position)
        holder.itemView.apply {
            Glide.with(this).load(article.urlToImage).into(holder.articleImageView)
            holder.titileTextView.text = article.title
            holder.descriptionTextView.text = article.description
            setOnClickListener { onClickListener?.invoke(article) }
        }
    }

}