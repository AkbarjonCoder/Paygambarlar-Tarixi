package com.example.paygambarlartarixi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.paygambarlartarixi.R
import com.example.paygambarlartarixi.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.wallpaper.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_wallpaperFragment)
        }
        binding.carton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_cartoonFragment)
        }

    }

}