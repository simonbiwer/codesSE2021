package org.hbrs.se1.ws21.demo.kapitel6.chain;

public class RegistrationDialog {

    private RegistrationControl registrationControl;

    public void handleUserEvent() {
        try {
            // get Data from User Interface --> put in UserDTO
            registrationControl.registerUser( new UserDTO() );
        } catch (RegisterException e) {
            // Handling the exception! Show message in a Dialog
            // showDialog( e.getReason() );
        }
    }
}
