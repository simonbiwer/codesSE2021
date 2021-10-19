package org.hbrs.se1.ws21.uebung2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    Container c;
    Item i;
    Item j;
    Item k;

    @BeforeEach
    void setUp() {
        c = new Container();
        i = new Item(1);
        j = new Item(2);
        k = new Item(3);
    }

    @Test
    void addMember() {
        Item j = new Item(1);
        try{
            c.addMember(i);
            c.addMember(j);
        } catch (ContainerException e){
//            assertThrows(ContainerException.class, () -> c.addMember(j));
            System.out.println(e);
        }
        assertEquals(1, c.size());
    }

    @Test
    void deleteMember() {
        try{
            c.addMember(i);
            c.addMember(j);
            c.addMember(k);
        } catch (ContainerException e) {
            System.out.println("Fehler");
        }
        c.deleteMember(1);
        assertEquals(2, c.size());
        c.deleteMember(2);
        assertEquals(1, c.size());
        assertEquals("Member mit der ID 37 ist nicht vorhanden", c.deleteMember(37));
    }

    @Test
    void dump() {
        try{
            c.addMember(i);
            c.addMember(j);
            c.addMember(k);
        } catch (ContainerException e){
            System.out.println("Fehler");
        }
        c.dump();       //Testergebnis durch Ablesen in der Konsole beurteilen
    }

    @Test
    void size() {
        try{
            c.addMember(i);
            c.addMember(j);
            c.addMember(k);
        } catch (ContainerException e){
            System.out.println("Fehler");
        }
        assertEquals(3, c.size());
    }
}