package com.example.desertorder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.desertorder.databinding.FragmentTypesDesertBinding
import com.example.desertorder.model.OrderViewModel

class TypesDeseetFragment: Fragment() {

    private var binding:FragmentTypesDesertBinding? = null
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentDesert = FragmentTypesDesertBinding.inflate(layoutInflater,container,false)
        binding = fragmentDesert
        return fragmentDesert.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            viewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner
            typesDesert = this@TypesDeseetFragment
        }
    }

    fun back() {
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_typesDeseetFragment_to_menuFragment)
    }

    fun nextPage() {
        findNavController().navigate(R.id.action_typesDeseetFragment_to_fragmentDates)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}