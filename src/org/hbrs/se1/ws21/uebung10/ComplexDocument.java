package org.hbrs.se1.ws21.uebung10;

import java.util.ArrayList;
import java.util.List;

public class ComplexDocument extends AbstractDocument{

    private List<Document> components;

    public ComplexDocument(){
        components = new ArrayList<>();
    }

    public int size(){
        int size = 0;
        for (Document d : components){
            size = size + d.size();
        }
        return size;
    }

    public void addComponent(Document d){
        components.add(d);
    }

    public void removeComponent(Document d){
        //löschen nicht implementiert
    }
}
