package com.example.mina.cairometro;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lines {
    List<String> selectedCities;
    int postion1, postion2;
    List<String> reverse;

    public lines(int postion1, int postion2) {
        this.postion1=postion1;
        this.postion2=postion2;
    }

    public List<String> comparePostions(List<String>data){
        if (postion1 <= postion2) {
            selectedCities = new ArrayList<String>(data.subList(postion1, postion2 ));
        } else if (postion2 < postion1) {
            reverse= new ArrayList<String>(data.subList(postion2-1,postion1+1));
            Collections.reverse(reverse);
            selectedCities = new ArrayList<String>(reverse);
        }
        return selectedCities;
    }

    public List<String> lineOneAndTwo(){


        return selectedCities;
    }

}
