package com.example.mina.cairometro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class allLinesData extends AppCompatActivity {

    int lineNum;
    String firstLineStations[];;
    String secondLineStations[];
    String thirdLineStations[];
    ListView listData;
    TextView txtLineNum,txtNumStations;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_line);
        listData=(ListView)findViewById(R.id.listData);
        //lineNum=getIntent().getIntExtra("key",0);
        txtLineNum=(TextView)findViewById(R.id.txtLineNum);
        txtNumStations=(TextView)findViewById(R.id.txtNumStations);
        Intent intent=getIntent();
        Bundle b=intent.getExtras();
        lineNum=b.getInt("key");
        if(lineNum==1){
            txtLineNum.setText("Line number: First Line");
            txtNumStations.setText("No. of stations: 35");
            firstLineStations= getResources().getStringArray(R.array.firstLine1);
            ArrayAdapter<String>adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.list_design,
                    R.id.txtDesign,firstLineStations);
            listData.setAdapter(adapter);

        }else  if(lineNum==2){
            txtLineNum.setText("Line number: Second Line");
            txtNumStations.setText("No. of stations: 20");
            secondLineStations= getResources().getStringArray(R.array.secondLine2);
            ArrayAdapter<String>adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.list_design,
                    R.id.txtDesign,secondLineStations);
            listData.setAdapter(adapter);
        }else  if(lineNum==3){
            txtLineNum.setText("Line number: Third Line");
            txtNumStations.setText("No. of stations: 09");
            thirdLineStations= getResources().getStringArray(R.array.thirdLine3);
            ArrayAdapter<String>adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.list_design,
                    R.id.txtDesign,thirdLineStations);
            listData.setAdapter(adapter);
        }


    }
}
