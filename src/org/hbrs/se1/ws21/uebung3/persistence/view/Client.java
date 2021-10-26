package org.hbrs.se1.ws21.uebung3.persistence.view;

import org.hbrs.se1.ws21.uebung2.Item;
import org.hbrs.se1.ws21.uebung2.Member;
import org.hbrs.se1.ws21.uebung3.persistence.control.Container;
import org.hbrs.se1.ws21.uebung3.persistence.control.ContainerException;
import org.hbrs.se1.ws21.uebung3.persistence.control.PersistenceException;

import java.util.List;

public class Client {
    private Container container;

    public Client(Container c){
        container = c;
    }

    public void show(){
        Member item1 = new Item(1);
        Member item2 = new Item(2);
        Member item3 = new Item(3);
        try {
            container.addMember(item1);
            container.addMember(item2);
            container.addMember(item3);
        } catch (ContainerException e){
            System.out.println("Fehler im Client");
        }
        MemberView mv = new MemberView();
        mv.dump(container.getCurrentList());
//        try {
//            container.addMember(item3);
//            container.store();
//        } catch (PersistenceException | ContainerException e) {
//            System.out.println(e);
//        }
//        try {
//            container.load();
//            MemberView mv = new MemberView();
//            mv.dump(container.getCurrentList());
//        } catch (PersistenceException e){
//            System.out.println(e);
//        }
    }
}
