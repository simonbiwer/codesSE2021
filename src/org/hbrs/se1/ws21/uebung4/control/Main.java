package org.hbrs.se1.ws21.uebung4.control;

import org.hbrs.se1.ws21.uebung2.Member;
import org.hbrs.se1.ws21.uebung3.persistence.control.Container;
import org.hbrs.se1.ws21.uebung3.persistence.control.PersistenceStrategyStream;
import org.hbrs.se1.ws21.uebung4.control.Dialog;

public class Main {
    public static void main(String[] args){
        Container container = Container.getContainer();
        PersistenceStrategyStream<Member> p = new PersistenceStrategyStream<>();
        container.setPersistenceStrategy(p);
        Dialog dialog = new Dialog(container);
        dialog.startDialog();

    }
}
