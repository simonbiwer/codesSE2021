package org.hbrs.se1.ws21.uebung3.persistence.view;

import org.hbrs.se1.ws21.uebung2.Member;

import java.util.List;

public class MemberView {
    public void dump(List<Member> liste){
        for (Member m : liste){
            System.out.println(m.toString());
        }
    }
}
