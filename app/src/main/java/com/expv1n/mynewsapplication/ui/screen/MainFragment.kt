package com.expv1n.mynewsapplication.ui.screen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.expv1n.mynewsapplication.R
import com.expv1n.mynewsapplication.data.models.Article
import com.expv1n.mynewsapplication.databinding.FragmentMainBinding
import com.expv1n.mynewsapplication.ui.adapter.MainScreenAdapter
import com.expv1n.mynewsapplication.ui.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding:  FragmentMainBinding
        get() = _binding ?: throw RuntimeException("Unknown FragmentBinding")
    private val viewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    private val coroutineMain = CoroutineScope(Dispatchers.Main)
    private lateinit var adapter: MainScreenAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        setOnClickListener()
        coroutineMain.launch {
            viewModel.getNews()
            viewModel.newsLiveData.observe(requireActivity()) {
                Log.d("MainActivity", "observe")
                adapter.submitList(it)
            }
        }
    }

    private fun setupAdapter() {
        adapter = MainScreenAdapter()
        binding.mainRecyclerView.adapter = adapter
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}