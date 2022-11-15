package com.example.paygambarlartarixi.fragment

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import com.example.paygambarlartarixi.MyImageManager
import com.example.paygambarlartarixi.R
import com.example.paygambarlartarixi.database.Image
import com.example.paygambarlartarixi.databinding.FragmentDetailBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


class DetailFragment : Fragment() {

    private lateinit var myImageManager: MyImageManager
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        initViews(view)
    }
//
//    private fun initViews(view: View) {
//        val newImage = arguments?.getParcelable<Image>("image")
//        newImage.let { image ->
//            binding.imageDetail.setImageResource(image?.image!!)
//        }
//
//    }

    inner class SetImage : AsyncTask<Unit, Unit, Unit>() {
        override fun doInBackground(vararg p0: Unit?) {
            val imageDetail: ImageView = view?.findViewById(R.id.imageDetail)!!
            val btnFon: FloatingActionButton = view?.findViewById(R.id.btnBackground)!!
            myImageManager = MyImageManager(requireActivity())
            myImageManager.setImage(imageDetail.drawable.toBitmap())
        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)
            Toast.makeText(requireActivity(), "Set Wallpaper", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}