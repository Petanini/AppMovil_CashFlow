package com.example.cashflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cashflow.databinding.FragmentListMovimientosBinding


class FragmentListMovimientos : Fragment() {
    private var _binding: FragmentListMovimientosBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListMovimientosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movements = listOf(
            Movement("COMPRA MOTOR DE BOMBEO", "25 JULIO 2024", 74.54, false),
            Movement("CUOTA CLIENTE 0007", "23 AGOSTO 2024", 134.99, true),
            Movement("VIATICOS GERENTE", "28 AGOSTO 2024", 40.0, false),
            Movement("INTERES CREDITO 4", "01 SEPTIEMBRE 2024", 55.99, false),
            Movement("CUOTA CLIENTE 0009", "05 SEPTIEMBRE 2024", 274.99, true)
        )

        binding.recyclerViewMovements.apply {
            adapter = MovementAdapter(movements)
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}