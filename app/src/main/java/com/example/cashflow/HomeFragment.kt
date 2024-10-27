package com.example.cashflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cashflow.databinding.ActivityMainBinding
import com.example.cashflow.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val listaCuentas = listOf(
            Cuenta("BCP HUARAZ", "**** **** **** 3445", "$323.54"),
            Cuenta("INTERBANK LIMA", "**** **** **** 5678", "$1250.20"),
            Cuenta("SCOTIABANK AREQUIPA", "**** **** **** 9876", "$750.00")
        )


        binding.recyclerViewCuentas.apply {
            adapter = CuentaAdapter(listaCuentas)
            layoutManager= LinearLayoutManager(requireContext())
        }
    }

}