package org.hbrs.se1.ws21.demo.kapitel6.chain;

public class RegistrationControl {

    private DBAccess dbAccess;

    public void registerUser( UserDTO dto ) throws RegisterException {
        try {
            dbAccess.store( dto );
        } catch (DatabaseException e) {
            // No Handling here!
            // Delegation in calling context
            // Transformation of Exception: ErrorCode123 --> "Something went wrong... " (more user-friendly)
            throw new RegisterException("Something went wrong. UserID is already available!");
        }
    }
}
