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
public class QuidditchControlException extends Exception {

    public QuidditchControlException() {
    }

    public QuidditchControlException(String message) {
        super(message);
    }

    public QuidditchControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuidditchControlException(Throwable cause) {
        super(cause);
    }

    public QuidditchControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
