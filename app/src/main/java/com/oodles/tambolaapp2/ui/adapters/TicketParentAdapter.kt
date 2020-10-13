package com.oodles.tambolaapp2.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oodles.tambolaapp2.R
import com.oodles.tambolaapp2.model.ModelTicketsParent


class TicketParentAdapter(
    val locationList: MutableList<ModelTicketsParent>,
    val context: Context
) : RecyclerView.Adapter<TicketParentAdapter.ViewHolder>() {

    var mContext: Context? = null

    init {
        mContext = context
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TicketParentAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.ticket_parent_adpter, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: TicketParentAdapter.ViewHolder, position: Int) {

        var listItem: ModelTicketsParent = locationList.get(position)

        holder.ticket_hash.setText("Ticket # " + listItem.ticket_no)
        holder.rv.setLayoutManager(GridLayoutManager(holder.rv.context, 9));
        holder.rv.setHasFixedSize(true);

        // Access RecyclerView Adapter and load the data
        var adapter = TicketChildAdapter(listItem.numbers, mContext,listItem.ticket_no)
        holder.rv?.adapter = adapter

    }


    override fun getItemCount(): Int {
        return locationList.count()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ticket_hash = itemView.findViewById<TextView>(R.id.locationDate)
        val rv = itemView.findViewById<RecyclerView>(R.id.locationList)
    }

}