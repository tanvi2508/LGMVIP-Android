package com.example.covid_19app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ListView listView;
    public static List<Model> modelList=new ArrayList<>();
    Model model;
    Adapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=(ImageView)findViewById(R.id.imageView2);
        listView=(ListView)findViewById(R.id.list_view);
         jsonParse();
    }

    private void jsonParse() {
        String url="https://data.covid19india.org/state_district_wise.json";
        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Iterator<String> data = jsonObject.keys();


                    while (data.hasNext()) {
                        String key = data.next();
                        JSONObject jsonObject1 = jsonObject.getJSONObject(key);
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("districtData");
                        Iterator<String> superKey = jsonObject2.keys();


                        while (superKey.hasNext()) {
                            String data1 = superKey.next();
                            JSONObject jsonObject3 = jsonObject2.getJSONObject(data1);
                            JSONObject jsonObject4 = jsonObject3.getJSONObject("delta");


                            String active = jsonObject3.getString("active");
                            String confirmed = jsonObject3.getString("confirmed");
                            String deceased = jsonObject3.getString("deceased");
                            String recovered = jsonObject3.getString("recovered");

                            String deltaConfirmed = jsonObject3.getString("confirmed");
                            String deltaDeceased = jsonObject3.getString("deceased");
                            String deltaRecovered = jsonObject3.getString("recovered");

                            model = new Model(data1, active, confirmed, deceased, recovered, deltaConfirmed, deltaDeceased, deltaRecovered);
                            modelList.add(model);


                        }

                    }
                    myAdapter=new Adapter(MainActivity.this,modelList);
                    listView.setAdapter(myAdapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);

    }
}