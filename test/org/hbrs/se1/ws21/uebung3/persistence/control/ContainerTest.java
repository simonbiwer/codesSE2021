package org.hbrs.se1.ws21.uebung3.persistence.control;

import org.hbrs.se1.ws21.uebung2.Item;
import org.hbrs.se1.ws21.uebung2.Member;
import org.hbrs.se1.ws21.uebung3.persistence.view.MemberView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    Container c = Container.getContainer();
    PersistenceStrategyStream p = new PersistenceStrategyStream();
    Member item1 = new Item(1);
    Member item2 = new Item(2);
    Member item3 = new Item(3);

    @BeforeEach
    void setUp() {
        c.setPersistenceStrategy(p);
    }
    @Test
    void testStore(){
        try{
            c.addMember(item1);
            c.addMember(item2);
            c.store();
        } catch (ContainerException | PersistenceException e){
            System.out.println("Fehler bei store: " + e.getMessage());
        }
    }
    @Test
    void testLoad(){
        try{
            c.load();
            MemberView mv = new MemberView();
            mv.dump(c.getCurrentList());
        } catch (PersistenceException e){
            System.out.println("Fehler bei load: " + e.getMessage());
        }
    }
}