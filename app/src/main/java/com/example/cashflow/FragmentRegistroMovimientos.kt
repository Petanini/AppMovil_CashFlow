package com.example.cashflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.cashflow.databinding.FragmentRegistroMovimientosBinding


class FragmentRegistroMovimientos : Fragment() {
    private var _binding: FragmentRegistroMovimientosBinding? = null
    private val binding get() = _binding!!

    private lateinit var dateselector: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout para este fragmento
        _binding = FragmentRegistroMovimientosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dateselector = binding.txtDate
        dateselector.setOnClickListener { showDatePickerDialog() }
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(childFragmentManager, "datePicker")
    }

    fun onDateSelected(day: Int, month: Int, year: Int) {
        dateselector.text = "$day/${month + 1}/$year"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}