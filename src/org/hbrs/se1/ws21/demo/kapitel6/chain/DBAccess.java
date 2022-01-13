package org.hbrs.se1.ws21.demo.kapitel6.chain;

public class DBAccess {

    public void store(UserDTO dto) throws DatabaseException {
        // Writing to Database. Something went wrong here!

        // Handling the exception (logging!)
        System.out.println("LOG: Database not working");

        // Delegation in calling context
        throw new DatabaseException("ErrorCode123");
    }
}
