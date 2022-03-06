package com.example.vivaclima.ui.view.ui.gallery

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vivaclima.R
import com.example.vivaclima.config.WheaderApi
import com.example.vivaclima.core.RetrofitHelper
import com.example.vivaclima.databinding.FragmentGalleryBinding
import com.example.vivaclima.model.WheatherResponse
import com.example.vivaclima.repository.WheatherRepository
import com.example.vivaclima.ui.view.adapter.WheatherAdapter
import com.example.vivaclima.ui.view.viewmodel.WheatherViewModel
import com.example.vivaclima.ui.view.viewmodel.WheatherViewModelFactory
import com.squareup.picasso.Picasso

class GalleryFragment : Fragment() {

    private lateinit var contexto: Context
    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        var wheatherViewModel: WheatherViewModel
        var consumirApi = RetrofitHelper.getInstance().create(WheaderApi::class.java)
        var wheatherRepository = WheatherRepository(consumirApi)
        wheatherViewModel = ViewModelProvider(this, WheatherViewModelFactory(wheatherRepository)).get()
        wheatherViewModel.wheather.observe(viewLifecycleOwner) {
            var wheather:MutableList<WheatherResponse> = ArrayList()
            val rv = root.findViewById<RecyclerView>(R.id.rv)
            rv.layoutManager = LinearLayoutManager(contexto)
            rv.adapter = WheatherAdapter(wheather)

        }


        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}