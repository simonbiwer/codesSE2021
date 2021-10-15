package org.hbrs.se1.ws21.uebung1.view;

import org.hbrs.se1.ws21.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws21.uebung1.control.Translator;

import java.util.ArrayList;
import java.util.List;

public class Assembler {
    /*public static void main(String[] args){
        Client c = new Client();
        c.display(11);
    }*/

    public void main(){
        Translator translator = new GermanTranslator();
        Client client = new Client(translator);
    }
}
