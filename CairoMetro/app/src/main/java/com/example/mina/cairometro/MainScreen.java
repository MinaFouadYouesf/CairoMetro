package com.example.mina.cairometro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainScreen extends AppCompatActivity {

    LinearLayout metroMap,metroLines;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        metroMap=(LinearLayout)findViewById(R.id.metromap);
        metroLines=(LinearLayout)findViewById(R.id.metrolines) ;
     /* metroMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainScreen.this,metroMaps.class);
                startActivity(intent);

            }
        });*/

    }
    public void goToNextScreen(View view){

        if (view.getId()==R.id.metrolines){
            Intent intent=new Intent(MainScreen.this,MetroLines.class);
            startActivity(intent);
        }else if(view.getId()==R.id.metromap){
           Intent intent=new Intent(MainScreen.this,cairoMap.class);
          startActivity(intent);
        }else if(view.getId()==R.id.from_to){
            Intent intent=new Intent(MainScreen.this,fromToStations.class);
            startActivity(intent);
        }else if(view.getId()==R.id.near){
            Intent intent=new Intent(MainScreen.this,MapsActivity.class);
          startActivity(intent);
        }
    }
}
