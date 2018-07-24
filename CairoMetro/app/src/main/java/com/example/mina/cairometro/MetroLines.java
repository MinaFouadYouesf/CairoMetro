package com.example.mina.cairometro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MetroLines extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metro_lines);

}
public  void displayLines(View view){
        int num=0;
        if(view.getId()==R.id.firstLine){
           num=1;
        }else if(view.getId()==R.id.secondLine){

            num=2;
        }else if(view.getId()==R.id.thirdLine){

            num=3;
        }
        Intent intent=new Intent(MetroLines.this,allLinesData.class);
        intent.putExtra("key",num);
        Log.d("key",String.valueOf(num));
        startActivity(intent);
}
}