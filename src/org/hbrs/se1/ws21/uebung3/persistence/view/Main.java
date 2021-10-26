package org.hbrs.se1.ws21.uebung3.persistence.view;

import org.hbrs.se1.ws21.uebung2.Member;
import org.hbrs.se1.ws21.uebung3.persistence.control.Container;
import org.hbrs.se1.ws21.uebung3.persistence.control.PersistenceStrategyStream;

public class Main {
    public static void main(String[] args){
        Container c = Container.getContainer();
        PersistenceStrategyStream<Member> p = new PersistenceStrategyStream<>();
        c.setPersistenceStrategy(p);
        Client client = new Client(c);
        client.show();
//        Container d = Container.createContainer();
//        try {
//            c.load();
//            c.dump();
//        } catch (PersistenceException e){
//            System.out.println(e.getStackTrace());
//        }

    }
}
