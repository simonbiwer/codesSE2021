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
    public static Container getContainer(){
        if (myContainer == null){
            return new Container();
        }
        return myContainer;
    }
    public void setPersistenceStrategy(PersistenceStrategy<Member> p){
        persistenceStrategy = p;
    }
    public void store() throws PersistenceException {
//        persistenceStrategy.openConnection();
        persistenceStrategy.save(list);
//        persistenceStrategy.closeConnection();
    }
    public void load() throws PersistenceException{
//        persistenceStrategy.openConnection();
        list = persistenceStrategy.load();
//        persistenceStrategy.closeConnection();
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
