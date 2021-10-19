package org.hbrs.se1.ws21.uebung2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Container {

    private List<Member> list;

    public Container(){
        list = new LinkedList<>();
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
    public void dump(){
        Iterator<Member> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next().toString());
        }
    }
    public int size(){
        return list.size();
    }

    //prüft ob das Member Objekt mit dieser ID schon im Container ist und gibt den Member
    // oder null (bei nicht Vorhandensein) zurück
    private Member contains(Integer id){
        Iterator<Member> it = list.iterator();
        while (it.hasNext()){
            Member m = it.next();
            if (m.getID() == id){
                return m;
            }
        }
        return null;
    }

}
