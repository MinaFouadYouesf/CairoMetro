package com.example.mina.cairometro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fromToStations extends AppCompatActivity {

    public String satation1 = "", station2 = "";
    public int postion1 = 0, postion2 = 0;
    public String firstLineStations[];
    public String secondLineStations[];
    public String thirdLineStations[];
    public ArrayList<String> allStations = new ArrayList<String>();
    Spinner spinner_from, spinner_to;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_to_stations);
        spinner_from = (Spinner) findViewById(R.id.from);
        spinner_to = (Spinner) findViewById(R.id.to);
        button = (Button) findViewById(R.id.dispalystations);
        firstLineStations = getResources().getStringArray(R.array.firstLine1);
        secondLineStations = getResources().getStringArray(R.array.secondLine2);
        thirdLineStations = getResources().getStringArray(R.array.thirdLine3);
        allStations.addAll(Arrays.asList(firstLineStations));
        allStations.addAll(Arrays.asList(secondLineStations));
        allStations.addAll(Arrays.asList(thirdLineStations));
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(fromToStations.this,
                android.R.layout.simple_spinner_item, allStations);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_from.setAdapter(adapter);
///////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        spinner_from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                postion1 = position; satation1 = allStations.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////
        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(fromToStations.this,
                android.R.layout.simple_spinner_item, allStations);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_to.setAdapter(adapter);
        spinner_to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                postion2 = position;
                station2 = allStations.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                   SearchStations searchStations = new SearchStations(firstLineStations, secondLineStations,
                        thirdLineStations, postion1, postion2, satation1, station2);
             searchStations.AllStations();
                 Intent intent = new Intent(fromToStations.this, displaySelectedStations.class);
                 Bundle b = new Bundle();
                  b.putSerializable("ob", (Serializable) searchStations);
                  intent.putExtra("bundle", b);
                startActivity(intent);
            }
        });
    }

}

