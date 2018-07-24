package com.example.mina.cairometro;

import android.support.v4.content.res.TypedArrayUtils;
import android.util.Log;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchStations implements Serializable{

    String station1 = "", station2 = "";
    List<String> selectedCities;
    List<String> selectedCities2;
    int postion1, postion2;
    List<String> firstLine = new ArrayList<String>();
    List<String> secondLine = new ArrayList<String>();
    List<String> thirdLine = new ArrayList<String>();
    int ShohadaPostionLineOne = 13, ShohadaPostionLineOTwo = 7;
    int attabaStationPostionLIne2=8,attabaStationPostionLIne3=0;

    public SearchStations(String firstLineStations[], String secondLineStations[], String thirdLineStations[],
                          int postion1, int postion2, String station1, String station2){

        this.postion1 = postion1;
        this.postion2 = postion2;
        this.station1 = station1;
        this.station2 = station2;
        firstLine = Arrays.asList(firstLineStations);
        secondLine = Arrays.asList(secondLineStations);
        thirdLine = Arrays.asList(thirdLineStations);
        selectedCities = new ArrayList<String>();
        selectedCities2 = new ArrayList<String>();

    }
    public void AllStations(){

        if (firstLine.contains(station1) && firstLine.contains(station2)) {

            lines lins=new lines(postion1, postion2+ 1);
            selectedCities= lins.comparePostions(firstLine);

        }
        if (secondLine.contains(station1) && secondLine.contains(station2)) {
            lines lins=new lines(postion1-35, postion2-34);
            selectedCities=lins.comparePostions(secondLine);
        } else if (thirdLine.contains(station1) && thirdLine.contains(station2)) {
            lines lins=new lines(postion1 - 55, postion2 - 54);
            selectedCities= lins.comparePostions(thirdLine);
        }
        else if ((firstLine.contains(station1) || firstLine.contains(station2))&&
                (secondLine.contains(station1) ||secondLine.contains(station2))){

            if (firstLine.contains(station1)&&secondLine.contains(station2)){
                lines lins=new lines(postion1+1,ShohadaPostionLineOne);
                selectedCities=lins.comparePostions(firstLine);
                lins.postion1=ShohadaPostionLineOTwo;
                lins.postion2=postion2-34;
                selectedCities.addAll(lins.comparePostions(secondLine));
            }
           else if(secondLine.contains(station1)&&firstLine.contains(station2)){
               Log.d("nuuuuuuuuuum1",String.valueOf(postion1-34)+"  "+String.valueOf(postion2)+"  "+
                       String.valueOf(ShohadaPostionLineOTwo+1));
                lines lins=new lines(postion1-35,ShohadaPostionLineOTwo);
                selectedCities=lins.comparePostions(secondLine);
                lins.postion1=ShohadaPostionLineOne;
                lins.postion2=postion2+1;
                selectedCities.addAll(lins.comparePostions(firstLine));


            }



        }else if ((secondLine.contains(station1) || secondLine.contains(station2))&&
                (thirdLine.contains(station1)||thirdLine.contains(station2))) {


            if (secondLine.contains(station1)&&thirdLine.contains(station2)){
                lines lins=new lines(postion1-35,attabaStationPostionLIne2);
                selectedCities=lins.comparePostions(secondLine);
                lins.postion1=attabaStationPostionLIne3;
                lins.postion2=postion2-54;
                selectedCities.addAll(lins.comparePostions(thirdLine));

            }else if((secondLine.contains(station2)) && thirdLine.contains(station1)){

                lines lins=new lines(postion1-55,attabaStationPostionLIne3+1);
                selectedCities=lins.comparePostions(thirdLine);
                lins.postion1=attabaStationPostionLIne2-1;
                lins.postion2=postion2-34;
                selectedCities.addAll(lins.comparePostions(secondLine));
            }
        }else if ((firstLine.contains(station1) || firstLine.contains(station2))&&
                (thirdLine.contains(station1)||thirdLine.contains(station2))) {
            if (firstLine.contains(station1)&&thirdLine.contains(station2)){
                lines lins=new lines(postion1+1,ShohadaPostionLineOne+1);
                selectedCities=lins.comparePostions(firstLine);
                lins.postion1=attabaStationPostionLIne3;
                lins.postion2=postion2-54;
                selectedCities.addAll(lins.comparePostions(thirdLine));

            }else if((firstLine.contains(station2)) && thirdLine.contains(station1)){

                lines lins=new lines(postion1-55,attabaStationPostionLIne3+1);
                selectedCities=lins.comparePostions(thirdLine);
                lins.postion1=ShohadaPostionLineOne;
                lins.postion2=postion2+1;
                selectedCities.addAll(lins.comparePostions(firstLine));
            }
        }

    }
    public List<String> selectedStation(){
        return selectedCities;
    }
}