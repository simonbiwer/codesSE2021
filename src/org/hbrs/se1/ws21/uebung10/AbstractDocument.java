package org.hbrs.se1.ws21.uebung10;

public abstract class AbstractDocument implements Document{

    private int id;

    public void setID(int id){
        this.id = id;
    }

    public int getID(){
        return id;
    }
}
