package com.example.covid_19app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adapter extends ArrayAdapter<Model> {
    private Context context;
    private List<Model> modelList;


    public Adapter(Context context, List<Model> modelList) {
        super(context, R.layout.testing, modelList);
        this.context = context;
        this.modelList = modelList;
    }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

           View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.testing,null,true);
            TextView district=view.findViewById(R.id.district);
            TextView active=view.findViewById(R.id.active_cases);
            TextView confirmed=view.findViewById(R.id.confirmed_cases);
            TextView deceased=view.findViewById(R.id.deceased_cases);
            TextView recovered=view.findViewById(R.id.recovered_cases);


            TextView deltaConfirmed=view.findViewById(R.id.confirmeddelta_cases);
            TextView deltaDeceased=view.findViewById(R.id.deceaseddelta_cases);
            TextView deltaRecovered=view.findViewById(R.id.recovereddelta_cases);



            district.setText(modelList.get(position).getDistrictName());
            active.setText(modelList.get(position).getActive());
            confirmed.setText(modelList.get(position).getConfirmed());
            deceased.setText(modelList.get(position).getDeceased());
            recovered.setText(modelList.get(position).getRecovered());

            deltaConfirmed.setText(modelList.get(position).getDeltaConfirmed());
            deltaDeceased.setText(modelList.get(position).getDeltaDeceased());
            deltaRecovered.setText(modelList.get(position).getDeltaRecovered());
            return view;
        }

    }
