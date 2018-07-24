package com.example.mina.cairometro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class displaySelectedStations extends AppCompatActivity {

    SearchStations stations;
    ListView listView;

            TextView ticketPrice,stationsNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_selected_stations);
        ticketPrice=(TextView)findViewById(R.id.ticketPrice);
        stationsNum=(TextView)findViewById(R.id.stationsNum);
        listView = (ListView) findViewById(R.id.listOfStations);
        Intent i = getIntent();
        Bundle b = i.getBundleExtra("bundle");
        stations = (SearchStations) b.getSerializable("ob");


        ticketPrice.setText("Ticket Price: "+String.valueOf(calculateTicketPrice((stations.selectedStation()).size()))+" LE");
        stationsNum.setText(String.valueOf(("No. of stations:"+(stations.selectedStation()).size())));
         //stations.getStations();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(displaySelectedStations.this,
                R.layout.list_design, R.id.txtDesign, stations.selectedStation());

        listView.setAdapter(arrayAdapter);
    }

    public int calculateTicketPrice(int num){
       int wage=0;
       if(num>=1&&num<=9){
           wage=3;
       }else if(num>=10&&num<=16){
           wage=5;
       }else if(num>16){
           wage=9;
       }
        return  wage;
    }


}
