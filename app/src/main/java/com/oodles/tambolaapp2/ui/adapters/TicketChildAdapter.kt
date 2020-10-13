package com.oodles.tambolaapp2.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oodles.tambolaapp2.R
import com.oodles.tambolaapp2.model.ModelTicketsChild
import es.dmoral.toasty.Toasty

class TicketChildAdapter(
    val ticketnumbers: MutableList<ModelTicketsChild>,
    mContext: Context?,
    val ticketNo: String?
) :
    RecyclerView.Adapter<TicketChildAdapter.ViewHolder>() {

    var mContext: Context? = null

    init {
        this.mContext = mContext
    }

    override fun onBindViewHolder(holder: TicketChildAdapter.ViewHolder, position: Int) {
        val numbers = ticketnumbers[position]
        holder.locationName?.text = numbers.udf1

        holder.locationName.setOnClickListener {
            Toasty.info(mContext!!,numbers.udf1.toString()+"  Ticket no : "+ticketNo).show()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TicketChildAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.ticket_child_adapter, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return ticketnumbers.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val locationName = itemView.findViewById<TextView>(R.id.locationName)
    }

}