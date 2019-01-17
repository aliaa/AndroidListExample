package com.example.ali.listtraining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class CityListActivity extends AppCompatActivity
{
    Spinner spCities;
    Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);

        spCities = (Spinner)findViewById(R.id.spCityList);
        String[] arr = getResources().getStringArray(R.array.cities);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                arr);
        spCities.setAdapter(adapter);

        btnOK = (Button)findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("city", (String)spCities.getSelectedItem());
                setResult(1, i);
                finish();
            }
        });
    }
}
