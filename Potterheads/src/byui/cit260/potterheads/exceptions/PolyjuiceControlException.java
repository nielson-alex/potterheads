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
public class PolyjuiceControlException extends Exception {

    public PolyjuiceControlException() {
    }

    public PolyjuiceControlException(String message) {
        super(message);
    }

    public PolyjuiceControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public PolyjuiceControlException(Throwable cause) {
        super(cause);
    }

    public PolyjuiceControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
