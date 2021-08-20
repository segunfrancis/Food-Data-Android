package com.segunfrancis.fooddataandroid.ui.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.segunfrancis.fooddataandroid.databinding.FragmentHomeBinding
import com.segunfrancis.fooddataandroid.FoodDataApplication
import com.segunfrancis.fooddataandroid.R
import com.segunfrancis.fooddataandroid.util.Result
import timber.log.Timber
import javax.inject.Inject

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var binding: FragmentHomeBinding

    @Inject
    lateinit var factory: HomeViewModelFactory

    private val viewModel: HomeViewModel by viewModels { factory }

    private val homeAdapter: HomeRecyclerAdapter by lazy { HomeRecyclerAdapter { } }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as FoodDataApplication).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        _binding = binding

        setupList()
    }

    private fun setupList() {
        binding.itemsRecyclerView.apply {
            adapter = homeAdapter
            layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.foodResponse.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Success -> {
                    homeAdapter.submitList(result.data)
                    binding.text.visibility = View.GONE
                }
                is Result.Loading -> {
                    binding.text.apply {
                        visibility = View.VISIBLE
                        text = "Loading..."
                    }
                }
                is Result.Error -> {
                    binding.text.apply {
                        visibility = View.VISIBLE
                        text = result.error.localizedMessage
                    }
                }
            }
            Timber.d(result.toString())
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
