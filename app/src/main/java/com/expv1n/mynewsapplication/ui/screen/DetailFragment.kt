package com.expv1n.mynewsapplication.ui.screen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.expv1n.mynewsapplication.data.models.Article
import com.expv1n.mynewsapplication.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding:  FragmentDetailBinding
        get() = _binding ?: throw RuntimeException("Unknown Binding")
    private lateinit var article: Article

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArticle()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        setScreen()
        initButton()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("DetailFragment", article.toString())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parseArticle() {
        requireArguments().getParcelable<Article>(PARSE_KEY)?.let {
            article = it
        }
    }

    private fun setScreen() {
        Glide.with(this).load(article.urlToImage).into(binding.detailImageView)
        binding.detailTitleTextView.text = article.title
        binding.detailDescriptionTextView.text = article.description
    }

    private fun initButton() {
        binding.detailGoToSourceButton.setOnClickListener {
            val uri = Uri.parse(article.url)
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }
    }

    companion object {

        const val NAME = "DETAIL_FRAGMENT"
        private const val PARSE_KEY = "DetailFragment"

        fun getInstance(article: Article): DetailFragment {
            return DetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(PARSE_KEY, article)
                }
            }
        }

    }
}