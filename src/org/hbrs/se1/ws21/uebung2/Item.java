package org.hbrs.se1.ws21.uebung2;

public class Item implements Member {
    private Integer id;

    public Item(Integer id){
        this.id = id;
    }

    @Override
    public Integer getID() {
        return id;
    }
    public String toString(){
        return "Member (ID = " + id + ")";
    }
}
