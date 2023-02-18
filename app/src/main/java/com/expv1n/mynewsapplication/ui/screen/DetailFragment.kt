package com.expv1n.mynewsapplication.ui.screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.expv1n.mynewsapplication.R
import com.expv1n.mynewsapplication.databinding.FragmentDetailBinding
import com.expv1n.mynewsapplication.databinding.FragmentMainBinding

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding:  FragmentDetailBinding
        get() = _binding ?: throw RuntimeException("Unknown Binding")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val NAME = "DETAIL_FRAGMENT"
        private const val INTENT_KEY = "DetailFragment"

        fun getInstance(context: Context): DetailFragment {
            return DetailFragment()
        }

    }
}