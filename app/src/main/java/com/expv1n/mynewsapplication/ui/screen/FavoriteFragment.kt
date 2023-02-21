package com.expv1n.mynewsapplication.ui.screen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.expv1n.mynewsapplication.R
import com.expv1n.mynewsapplication.data.database.ArticleEntity
import com.expv1n.mynewsapplication.data.models.Article
import com.expv1n.mynewsapplication.databinding.FragmentFavoriteBinding
import com.expv1n.mynewsapplication.ui.adapter.FavoriteScreenAdapter
import com.expv1n.mynewsapplication.ui.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteFragment : Fragment() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }
    private val adapter by lazy {
        FavoriteScreenAdapter()
    }
    private var _binding: FragmentFavoriteBinding? = null
    private val binding: FragmentFavoriteBinding
        get() = _binding ?: throw RuntimeException("Unknown Binding")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        setOnClickListener()
        coroutineScope.launch {
            viewModel.getFavoriteList()
            viewModel.favoriteNewsLiveData.observe(requireActivity()) {
                Log.d("FavoriteFragment", it.toString())
                adapter.submitList(it)
            }
        }
    }

    private fun setOnClickListener() {
        adapter.onClickListener = {
            launchFragment(it)
        }
    }

    private fun launchFragment(article: Article) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainerView, DetailFragment.getInstance(article))
            .addToBackStack(DetailFragment.NAME)
            .commit()
    }

    private fun setupAdapter() {
        binding.favoriteRecyclerView.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        fun getInstance(): FavoriteFragment {
            return FavoriteFragment()
            }
    }
}
