package com.example.praju.coffeeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class volley extends AppCompatActivity {

    EditText data;
    Button get,set;
    String responsetext="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        data=(EditText)findViewById(R.id.etdata);
        get=(Button)findViewById(R.id.btnget);
        set=(Button)findViewById(R.id.btnset);


        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest stringRequest= new StringRequest(Request.Method.POST, "https://aniketlahamge.000webhostapp.com/CoffeeApp/append.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try{

                                    JSONObject o=new JSONObject(response);
                                    if (!o.getBoolean("error")){
                                        Toast.makeText(getApplicationContext(),"Thanks for your feedback",Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(),"Feedback not submitted",Toast.LENGTH_SHORT).show();
                                    }

                                }
                                catch (JSONException e){
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params= new HashMap<>();
                        params.put("feedback",data.getText().toString());
                        return params;
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(volley.this);
                requestQueue.add(stringRequest);
            }
        });


        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest stringRequest= new StringRequest(Request.Method.POST, "https://aniketlahamge.000webhostapp.com/CoffeeApp/request.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try{

                                    JSONArray jsonArray=new JSONArray(response);
                                    for(int i=0;i<jsonArray.length();i++)
                                    {
                                        JSONObject o=jsonArray.getJSONObject(i);
                                        responsetext+=o.getString("feedback")+"\n";
                                    }

                                }
                                catch (JSONException e){
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });

                RequestQueue requestQueue=Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);
                Intent intent=new Intent(getApplicationContext(),GetFeedback.class);
                intent.putExtra("result",responsetext);
                responsetext="";
                startActivity(intent);


            }
        });

    }

}
