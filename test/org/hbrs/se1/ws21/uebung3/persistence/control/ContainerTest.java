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
    PersistenceStrategyStream<Member> p = new PersistenceStrategyStream<>();
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
    @Test
    void testCase1(){       //Test auf keine gesetzte Strategie, also NULL
        c.setPersistenceStrategy(null);
        try {
            c.addMember(item1);
            c.addMember(item2);
            assertThrows(PersistenceException.class, () -> c.store());
            assertThrows(PersistenceException.class, () -> c.load());
        } catch (ContainerException e){
            System.out.println("testCase1 failed");
        }
    }
    @Test
    void testCase2(){
        c.setPersistenceStrategy(new PersistenceStrategyMongoDB<>());
        try {
            c.addMember(item1);
            c.addMember(item2);
            assertThrows(UnsupportedOperationException.class, () -> c.store());
            assertThrows(UnsupportedOperationException.class, () -> c.load());
        } catch (ContainerException e){
            System.out.println("testCase2 failed");
        }
    }
    @Test
    void testCase3(){
        p.setLocation("C/dev/Test");
        try {
            c.addMember(item1);
            c.addMember(item2);
            assertThrows(PersistenceException.class, () -> c.store());
            assertThrows(PersistenceException.class, () -> c.load());
        } catch (ContainerException e){
            System.out.println("testCase3 failed");
        }
    }
    @Test
    void testCase4(){
        try{
            c.addMember(item1);
            assertEquals(1, c.size());
            c.store();
            assertEquals(1, c.size());
            c.deleteMember(1);
            assertEquals(0, c.size());
            c.load();
            assertEquals(1, c.size());
        } catch (ContainerException | PersistenceException e){
            System.out.println("testCase4 failed");
        }
    }
}