/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.Exception;

/**
 *
 * @author KH
 */
public class EONotRecognizedException extends Exception {
    
    public EONotRecognizedException(String objectName) {
        super("EnterpriseObject "+objectName+" is not registered!");
    }
    
    
}
