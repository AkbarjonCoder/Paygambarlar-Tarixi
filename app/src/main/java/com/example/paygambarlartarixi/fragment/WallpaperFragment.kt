package com.example.paygambarlartarixi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.paygambarlartarixi.R
import com.example.paygambarlartarixi.adapter.TarixAdapter
import com.example.paygambarlartarixi.databinding.FragmentWallpaperBinding
import com.example.paygambarlartarixi.util.ObjectList
import com.google.android.material.bottomnavigation.BottomNavigationView

class WallpaperFragment : Fragment() {

    private var _binding: FragmentWallpaperBinding? = null
    private val binding get() = _binding!!
    private lateinit var tarixAdapter: TarixAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navBar = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNav)
        navBar.isVisible = false
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWallpaperBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tarixAdapter = TarixAdapter()
        tarixAdapter.imageList = ObjectList.tarixList
        binding.recyclerView.apply {
            adapter = tarixAdapter
            layoutManager = GridLayoutManager(requireContext(), 3)
        }
        tarixAdapter.onItemClicked = {
            val bundle = bundleOf("image" to it)
            findNavController().navigate(R.id.action_wallpaperFragment_to_detailFragment, bundle)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        val navBar = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNav)
        navBar.isVisible = true
    }

}