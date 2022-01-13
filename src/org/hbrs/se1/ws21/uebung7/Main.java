package org.hbrs.se1.ws21.uebung7;

public class Main {

    public static void main(String[] args){
        DataManager dm = new DataManager();
        Producer p = new Producer();
        dm.addData(p.createData());
        System.out.println(dm.toString());
    }
}
