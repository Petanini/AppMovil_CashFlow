package com.example.cashflow
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovementAdapter(private val movements: List<Movement>) :
    RecyclerView.Adapter<MovementAdapter.MovementViewHolder>() {

    // ViewHolder para el RecyclerView
    inner class MovementViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvDate: TextView = itemView.findViewById(R.id.tvDate)
        val tvAmount: TextView = itemView.findViewById(R.id.tvAmount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovementViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movement, parent, false)
        return MovementViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovementViewHolder, position: Int) {
        val movement = movements[position]
        holder.tvTitle.text = movement.title
        holder.tvDate.text = movement.date

        // Configurar el monto y cambiar el color basado en si es ingreso o gasto
        holder.tvAmount.text = "${if (movement.isIncome) "+" else "-"} ${movement.amount} $"
        holder.tvAmount.setTextColor(
            holder.itemView.context.getColor(if (movement.isIncome) R.color.green else R.color.red)
        )
    }

    override fun getItemCount(): Int = movements.size
}
