package org.hbrs.se1.ws21.uebung3.persistence.control;

import org.hbrs.se1.ws21.uebung3.persistence.control.PersistenceException;
import org.hbrs.se1.ws21.uebung3.persistence.control.PersistenceStrategy;
import org.hbrs.se1.ws21.uebung2.Member;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PersistenceStrategyStream<Member> implements PersistenceStrategy<Member> {

    // URL of file, in which the objects are stored
    private String location = "objects.ser";

    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    /**
     * Method for opening the connection to a stream (here: Input- and Output-Stream)
     * In case of having problems while opening the streams, leave the code in methods load
     * and save
     */
    public void openConnection() throws PersistenceException {
        Path path = Paths.get(this.location);
        if (Files.isDirectory(path)){
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, "File darf kein Directory sein");
        }
    }

    @Override
    /**
     * Method for closing the connections to a stream
     */
    public void closeConnection() throws PersistenceException {
    /*   try{
           oos.close();
           fos.close();
           ois.close();
           fis.close();
       } catch (IOException e){
//           System.out.println(e);
           throw new PersistenceException(PersistenceException.ExceptionType.IOException, "Fehler");
       }*/
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<Member> member) throws PersistenceException {
        openConnection();
        try (FileOutputStream fos = new FileOutputStream(location);     //try-with-resources Block, schließt Closeable automatisch
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(member);
        } catch (IOException e){
//            System.out.println(e);
            throw new PersistenceException(PersistenceException.ExceptionType.IOException, e.getMessage());
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<Member> load() throws PersistenceException  {
        openConnection();
        try (FileInputStream fis = new FileInputStream(location);   //try-with-resources Block, schließt Closeable automatisch
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>){
                return (List<Member>) obj;
            }
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "Keine Liste gefunden");
        } catch (IOException | ClassNotFoundException e){
//            System.out.println(e.getMessage());
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable, e.getMessage());
        }

        // Some Coding hints ;-)
        // ObjectInputStream ois = null;
        // FileInputStream fis = null;
        // List<...> newListe =  null;
        //
        // Initiating the Stream (can also be moved to method openConnection()... ;-)
        // fis = new FileInputStream( " a location to a file" );
        // ois = new ObjectInputStream(fis);

        // Reading and extracting the list (try .. catch ommitted here)
        // Object obj = ois.readObject();

        // if (obj instanceof List<?>) {
        //       newListe = (List) obj;
        // return newListe

        // and finally close the streams (guess where this could be...?)
//        return null;
    }
}
