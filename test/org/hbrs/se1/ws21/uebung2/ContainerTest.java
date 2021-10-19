package org.hbrs.se1.ws21.uebung2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    Container c;
    Member i;
    Member j;
    Member k;

    @BeforeEach
    void setUp() {
        c = new Container();
        i = new Item(1);
        j = new Item(2);
        k = new Item(3);
    }

    @Test
    void addMember() {
        //pos Fall; Einfügen von neuen Member
        try{
            c.addMember(i);
            c.addMember(j);
            c.addMember(k);
        } catch (ContainerException e){
        }
        assertEquals(3, c.size());
        //neg Fall; Einfügen eines Members mit bereits vorhandener ID
        Member x = new Item(1);
        assertThrows(ContainerException.class, () -> c.addMember(x));
        assertEquals(3, c.size());
    }

    @Test
    void deleteMember() {
        //pos Fall; Löschen eines vorhandenen Members
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
        //neg Fall; Löschen eines nicht vorhandenen Members
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
            assertEquals(1, c.size());
            c.addMember(j);
            assertEquals(2, c.size());
            c.addMember(k);
        } catch (ContainerException e){
            System.out.println("Fehler");
        }
        assertEquals(3, c.size());
    }
}