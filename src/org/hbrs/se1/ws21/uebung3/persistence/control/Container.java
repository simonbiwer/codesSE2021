package org.hbrs.se1.ws21.uebung3.persistence.control;

import org.hbrs.se1.ws21.uebung2.Member;

import java.util.LinkedList;
import java.util.List;

public class Container {
    private List<Member> list;
    private static Container myContainer;
    private PersistenceStrategy<Member> persistenceStrategy;

    private Container(){
        list = new LinkedList<>();
//        persistenceStrategy = new PersistenceStrategyStream<>();
    }
    //stellt sicher dass nur ein Container Objekt erzeugt werden kann (Singleton-Pattern)
    //Lösung nicht thread-safe! (Beispiel mit 2 Clients)
    //alternative Lösung mit unmittelbarer Erzeugung bei Laden der Klasse zwar thread-safe aber hoher Speicherbedarf
    private final static Object lock = new Object();
    public static Container getContainer(){
        synchronized (lock) {           //stellt sicher dass nur ein Objekt gleichzeitig in den Block kann
            if (myContainer == null){
                return new Container();
            }
        }
        return myContainer;
    }
    public void setPersistenceStrategy(PersistenceStrategy<Member> p){
        persistenceStrategy = p;
    }
    public void store() throws PersistenceException {       //Fehlendes Exception Handling bei MongoDB Strategie
        if (persistenceStrategy == null){
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "No Strategy set");
        }
        persistenceStrategy.save(list);
    }
    public void load() throws PersistenceException{
        if (persistenceStrategy == null){
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "No Strategy set");
        }
        list = persistenceStrategy.load();
    }
    public void loadMerge() throws PersistenceException{
        if (persistenceStrategy == null){
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "No Strategy set");
        }
        List<Member> loadMember = persistenceStrategy.load();
        for (Member neu : loadMember){
            boolean schonDrin = false;
            for (Member alt : list){
                if (neu.getID().equals(alt.getID())){
                    schonDrin = true;
                }
            }
            if (schonDrin){
                continue;
            }
            list.add(neu);
        }
    }

    public void addMember(Member member) throws ContainerException {
        if (contains(member.getID()) != null){
            throw new ContainerException(member.getID());
        }
        list.add(member);
    }
    public String deleteMember(Integer id){
        Member m = contains(id);
        if (m == null){
            return "Member mit der ID " + id +" ist nicht vorhanden";
        }
        list.remove(m);
        return "Member mit der ID " + id + " wurde entfernt";
    }
    public List<Member> getCurrentList(){
        return list;
    }
    public int size(){
        return list.size();
    }

    //prüft ob das Member Objekt mit dieser ID schon im Container ist und gibt den Member
    // oder null (bei nicht Vorhandensein) zurück
    private Member contains(Integer id){
        for (Member m : list){
            if (m.getID() == id){
                return m;
            }
        }
        return null;
    }
}
