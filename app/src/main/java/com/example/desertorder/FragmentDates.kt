package com.example.desertorder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.desertorder.databinding.FragmentDatesBinding
import com.example.desertorder.model.OrderViewModel

class FragmentDates: Fragment() {

    private var binding:FragmentDatesBinding? = null
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragment =  FragmentDatesBinding.inflate(layoutInflater,container,false)
        binding = fragment
        return fragment.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            viewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner
            datesFragment = this@FragmentDates
        }
    }

    fun back() {
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_fragmentDates_to_menuFragment)
    }

   fun nextPage() {
        findNavController().navigate(R.id.action_fragmentDates_to_summaryFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}