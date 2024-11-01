package com.example.cashflow.model.providers
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cashflow.R
import com.example.cashflow.model.entities.Cuenta

class CuentaAdapter(private val cuentas: List<Cuenta>) : RecyclerView.Adapter<CuentaAdapter.CuentaViewHolder>() {


    inner class CuentaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreBanco: TextView = itemView.findViewById(R.id.bankName)
        val numeroCuenta: TextView = itemView.findViewById(R.id.bankNumber)
        val balanceCuenta: TextView = itemView.findViewById(R.id.bankBalance)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuentaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.lista_cuenta_card, parent, false)
        return CuentaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CuentaViewHolder, position: Int) {
        val cuenta = cuentas[position]
        holder.nombreBanco.text = cuenta.nombreBanco
        holder.numeroCuenta.text = cuenta.numeroCuenta
        holder.balanceCuenta.text = cuenta.balance
    }

    override fun getItemCount() = cuentas.size
}
