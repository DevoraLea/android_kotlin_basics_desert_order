package com.example.desertorder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.desertorder.databinding.FragmentMenuBinding
import com.example.desertorder.model.OrderViewModel
import com.google.android.material.snackbar.Snackbar

class MenuFragment:Fragment()
{
    private var binding: FragmentMenuBinding? = null
    private val sharedViewModel:OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var fragment = FragmentMenuBinding.inflate(layoutInflater,container,false)
        binding = fragment
        return fragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            menu = this@MenuFragment
        }
    }
    fun amountCupcakes(amount:Int){
        sharedViewModel.setQuatity(amount)
        if(sharedViewModel.hasNoTypeDesert()){
            sharedViewModel.setTypeDesert(getString(R.string.chocolate_cake))
        }
        findNavController().navigate(R.id.action_menuFragment_to_typesDeseetFragment2)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}