package com.example.covid_19app;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class DataFetch {
    private static DataFetch instance;
    private RequestQueue requestQueue;

    private static Context cxt;

    private DataFetch(Context context){
     cxt=context;
        requestQueue=getRequestQueue();

    }
    public static synchronized DataFetch getInstance(Context context){
        if (instance==null){
            instance=new DataFetch(context);
        }
        return instance;
    }

    private RequestQueue getRequestQueue() {
        if (requestQueue==null){
            requestQueue= Volley.newRequestQueue(cxt.getApplicationContext());
        }
        return requestQueue;
    }

}
