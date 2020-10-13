package com.oodles.tambolaapp2.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.oodles.tambolaapp2.R
import com.oodles.tambolaapp2.model.ModelTicketsParent
import com.oodles.tambolaapp2.network.ApiInterface
import com.oodles.tambolaapp2.network.RestAdapter
import com.oodles.tambolaapp2.ui.adapters.TicketParentAdapter
import kotlinx.android.synthetic.main.activity_view_all_tickets.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewAllTickets : AppCompatActivity() {


    var ticketsList:MutableList<ModelTicketsParent> = mutableListOf()
    private lateinit var ticketParentAdapter: TicketParentAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_all_tickets)

        getAllTicketsFromServer()
        // push test.cjsjncjs
    }

    private fun getAllTicketsFromServer() {

        val apiInterface: ApiInterface = RestAdapter.createAPI()
        apiInterface.getAllTickets("28991e05/").enqueue(object :
            Callback<List<ModelTicketsParent>> {

            override fun onResponse(call: Call<List<ModelTicketsParent>>, response: Response<List<ModelTicketsParent>>) {

                ticketsList = response.body()!!.toMutableList()

                ticketParentAdapter = TicketParentAdapter(ticketsList,this@ViewAllTickets)
                locationDatesList.apply {

                    layoutManager =
                        LinearLayoutManager(this@ViewAllTickets, LinearLayoutManager.VERTICAL, false)
                    adapter = ticketParentAdapter
                }
            }

            override fun onFailure(call: Call<List<ModelTicketsParent>>, t: Throwable) {
                Log.e("onFailure", t.message)


            }
        })


    }
}