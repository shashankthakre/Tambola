package com.oodles.tambolaapp2.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.JsonObject
import com.oodles.tambolaapp2.R
import com.oodles.tambolaapp2.model.ModelAuthResponse
import com.oodles.tambolaapp2.model.ModelTicketsParent
import com.oodles.tambolaapp2.network.ApiInterface
import com.oodles.tambolaapp2.network.RestAdapter
import com.oodles.tambolaapp2.ui.adapters.TicketParentAdapter
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_view_all_tickets.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        btnLogin.setOnClickListener {
            //getAuthentication()
            val intent = Intent(this@AuthActivity, OtpActivity::class.java)
            startActivity(intent)
        }


    }


    private fun getAuthentication() {

        var paramObject = JsonObject();
        paramObject.addProperty("phone_number", "phone_number");
        paramObject.addProperty("registration_code", "registration_code");
        paramObject.addProperty("device_type", "device_type");
        paramObject.addProperty("device_token", "device_token");
        paramObject.addProperty("os_version", "os_version");
        paramObject.addProperty("device_model", "device_model");

        val apiInterface: ApiInterface = RestAdapter.createAPI()
        apiInterface.getLoginResponse("token", paramObject)!!.enqueue(object :
            Callback<ModelAuthResponse> {
            override fun onResponse(
                call: Call<ModelAuthResponse>,
                response: Response<ModelAuthResponse>
            ) {

                var response1=response.body()
                if(response1!!.message.equals("success"))
                {
                    if(response1!!.new_user.equals("Y"))
                    {
                        val intent = Intent(this@AuthActivity, OtpActivity::class.java)
                        startActivity(intent)
                    }else if(response1!!.new_user.equals("N"))
                    {
                        val intent = Intent(this@AuthActivity, MainActivity::class.java)
                        startActivity(intent)
                    }
                }else
                {
                    Toasty.error(this@AuthActivity,response1.message.toString()).show()
                }




            }

            override fun onFailure(call: Call<ModelAuthResponse>, t: Throwable) {

                Toasty.error(this@AuthActivity,t.message.toString()).show()


            }


        })


    }
}