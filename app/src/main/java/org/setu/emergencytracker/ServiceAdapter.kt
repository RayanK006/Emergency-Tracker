package org.setu.emergencytracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlacedMarkAdapter(
    private var marks: List<Service>,
    private val onEdit: (Service) -> Unit,
    private val onDelete: (Service) -> Unit
) : RecyclerView.Adapter<PlacedMarkAdapter.MarkViewHolder>() {

    class MarkViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val mainTitle: TextView =
            itemView.findViewById(R.id.mainTitle)

        val descText: TextView =
            itemView.findViewById(R.id.descText)

        val coordinationText: TextView =
            itemView.findViewById(R.id.coordinationText)

        val editButton: Button =
            itemView.findViewById(R.id.editButton)

        val deleteButton: Button =
            itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MarkViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_placed_service,
                parent,
                false
            )

        return MarkViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MarkViewHolder,
        position: Int
    ) {

        val mark = marks[position]

        holder.mainTitle.text =
            "${mark.id}: ${mark.title}"

        holder.descText.text =
            mark.desc

        holder.coordinationText.text =
            "X: ${mark.x}, Y: ${mark.y}"

        holder.editButton.setOnClickListener {
            onEdit(mark)
        }

        holder.deleteButton.setOnClickListener {
            onDelete(mark)
        }
    }

    override fun getItemCount(): Int {
        return marks.size
    }

    fun updateMarks(newMarks: List<Service>) {
        marks = newMarks
        notifyDataSetChanged()
    }
}
