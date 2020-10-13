package com.oodles.tambolaapp2.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.JsonObject
import com.oodles.tambolaapp2.R
import com.oodles.tambolaapp2.model.ModelAuthResponse
import com.oodles.tambolaapp2.model.ModelOtpResponse
import com.oodles.tambolaapp2.network.ApiInterface
import com.oodles.tambolaapp2.network.RestAdapter
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_otp.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OtpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)


        verify_btn.setOnClickListener {

           // getOtpVarification()
            val intent = Intent(this@OtpActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getOtpVarification() {

        var paramObject = JsonObject();
        paramObject.addProperty("user_id", "user_id");
        paramObject.addProperty("otp", "otp");

        val apiInterface: ApiInterface = RestAdapter.createAPI()
        apiInterface.getOtpResponse("token", paramObject)!!.enqueue(object :
            Callback<ModelOtpResponse> {
            override fun onResponse(
                call: Call<ModelOtpResponse>,
                response: Response<ModelOtpResponse>
            ) {

                var response1=response.body()
                if(response1!!.message.equals("success"))
                {
                    val intent = Intent(this@OtpActivity, MainActivity::class.java)
                    startActivity(intent)

                }else
                {
                    Toasty.error(this@OtpActivity,response1.message.toString()).show()
                }




            }

            override fun onFailure(call: Call<ModelOtpResponse>, t: Throwable) {

                Toasty.error(this@OtpActivity,t.message.toString()).show()


            }


        })


    }
}