/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.Exception;

/**
 *
 * @author KH
 */
public class ContextNotAllowedException extends Exception {
    
    public ContextNotAllowedException(String operation) {
        super("Operation ["+operation+"] not allowed in the current context.");
    }
}
