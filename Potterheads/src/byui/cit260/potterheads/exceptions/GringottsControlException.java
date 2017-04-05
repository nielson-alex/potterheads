/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.exceptions;

/**
 *
 * @author Alex
 */
public class GringottsControlException extends Exception {

    public GringottsControlException() {
    }

    public GringottsControlException(String message) {
        super(message);
    }

    public GringottsControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public GringottsControlException(Throwable cause) {
        super(cause);
    }

    public GringottsControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
