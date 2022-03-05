package com.example.desertorder

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.desertorder.databinding.FragmentSummaryBinding
import com.example.desertorder.model.OrderViewModel
import java.text.SimpleDateFormat
import java.util.*


class SummaryFragment : Fragment() {

    private var binding:FragmentSummaryBinding? = null
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragment = FragmentSummaryBinding.inflate(layoutInflater,container,false)
        binding = fragment
        return fragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            viewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner
            summaryFragment = this@SummaryFragment
        }
    }

    fun cancel() {
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_summaryFragment_to_menuFragment)
    }

    fun send() {
        val orderDetail = getString(R.string.order_details, sharedViewModel.typeDesert.value.toString(),sharedViewModel.quantity.value.toString(),
        sharedViewModel.dateOrder.value.toString(),sharedViewModel.price.value.toString())


        val intent = Intent(Intent.ACTION_SEND)
            .setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT,orderDetail)
        intent.putExtra(Intent.EXTRA_SUBJECT,getString(R.string.order_title))
        if(activity?.packageManager?.resolveActivity(intent,0)!= null){
            startActivity(intent)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}