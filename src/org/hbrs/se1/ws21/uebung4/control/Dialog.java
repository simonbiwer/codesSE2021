package org.hbrs.se1.ws21.uebung4.control;

import org.hbrs.se1.ws21.uebung2.Member;
import org.hbrs.se1.ws21.uebung3.persistence.control.Container;
import org.hbrs.se1.ws21.uebung3.persistence.control.ContainerException;
import org.hbrs.se1.ws21.uebung3.persistence.control.PersistenceException;
import org.hbrs.se1.ws21.uebung4.view.MitarbeiterView;
import org.hbrs.se1.ws21.uebung4.model.Mitarbeiter;

import java.util.*;

public class Dialog {

    public Dialog(Container container){
        this.container = container;
    }

    private static Container container;

    public static void startDialog(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Geben Sie einen Befehl ein");
        boolean ende = false;
        String s;
        while (!ende) {
            s = sc.nextLine();
            String[] zeile = s.split(" ");
            switch (zeile[0]) {
                case "enter":
                    enter(zeile, sc);
                    break;
                case "store":
                    store();
                    break;
                case "load":
                    load(zeile);
                    break;
                case "dump":
                    if (zeile.length == 3){
                        MitarbeiterView.dump(container.getCurrentList(), zeile[2]);
                    } else{
                        MitarbeiterView.dump(container.getCurrentList(),  null);       //Filter-Map-Reduce?
                    }
                    break;
                case "exit":
                    ende = true;
                    break;
                case "help":
                    help();
                    break;
                case "search":
                    search(zeile);
                    break;
                default:
                    System.out.println("Ungültiger Befehl, zur Befehlsübersicht 'help' eingeben");
                    break;
            }
        }
    }

    private static void enter(String[] zeile, Scanner sc){      //Fehler Handling fehlt noch
        Integer id = 0;
        try{
            id = Integer.parseInt(zeile[1]);
        } catch (NumberFormatException e){
            System.out.println("Der erste Parameter muss eine Zahl sein");
        }
        System.out.println("Abteilung?: ");
        String abteilung;
        String[] s = sc.nextLine().split(" ");
        if (s[0].equals("ja")){
            abteilung = s[1];
        }else{
            abteilung = " - ";
        }
        HashMap<String, Integer> expertisen = new HashMap<>();
        for (int i = 0; i < 3; ++i){
            System.out.println("Expertise eingeben? (ja/nein): ");
            String[] x = sc.nextLine().split(" ");
            if (x[0].equals("ja")){
                System.out.print("Expertise: ");
                String exp = sc.nextLine().split(" ")[0];
                System.out.print("Expertise-Level: ");
                Integer lvl = Integer.parseInt(sc.nextLine().split(" ")[0]);
                expertisen.put(exp, lvl);
            }
            break;
        }
        Mitarbeiter m = new Mitarbeiter(id, zeile[2], zeile[3], zeile[4], abteilung, expertisen);
        try{
            container.addMember(m);
        } catch (ContainerException e1){
            System.out.println(e1.getMessage());
        }
        System.out.println("Mitarbeiter eingefügt!");
    }
    private static void store(){
        try {
            container.store();
        } catch (PersistenceException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Mitarbeiter gespeichert!");
    }
    private static void load(String[] zeile){
        if (zeile[1].equals("merge")){
            try{
                container.loadMerge();
            } catch (PersistenceException e){
                System.out.println(e.getMessage());
            }
        }
        if (zeile[1].equals("force")){
            try {
                container.load();
            } catch (PersistenceException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Laden erfolgreich!");
    }
    private static void help(){
        System.out.println("Eingabe eines Mitarbeiters: enter [ID, Vorname, Name, Rolle]");
        System.out.println("Speichern der Mitarbeiter: store");
        System.out.println("Laden aus Speicher: load [force oder merge]");
        System.out.println("Ausgabe der Mitarbeiter: dump Optional:[Abteilung abteilung]");
        System.out.println("Beenden des Programms: exit");
        System.out.println("Suche nach Mitarbeitern mit Expertise: search [Expertise]");
    }
    private static void search(String[] zeile){     //Problem: das Expertise Level ist nirgends zu sehen
        String suchwort = zeile[1];
        ArrayList<Member> rightOnes = new ArrayList<>();
        for (Member m : container.getCurrentList()){
            Mitarbeiter ma;
            if (m instanceof Mitarbeiter){
                ma = (Mitarbeiter) m;
            } else{
                throw new IllegalArgumentException("Es sind nur Mitarbeiter erlaubt");
            }
            if (ma.getExpertisen().containsKey(suchwort)){
                rightOnes.add(ma);
            }
        }
        System.out.println("Diese Mitarbeiter haben als Expertise '" + suchwort + "':");
        MitarbeiterView.dump(rightOnes, null);
    }
}
