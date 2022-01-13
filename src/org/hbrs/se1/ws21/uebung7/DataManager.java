package org.hbrs.se1.ws21.uebung7;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private List<Data> data;

    public DataManager(){
        data = new ArrayList<>();
    }

    public void addData(Data d){
        data.add(d);
    }
    public String toString(){
        return data.get(0).getName();
    }
}
