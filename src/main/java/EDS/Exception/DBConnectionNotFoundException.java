/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.Exception;

/**
 *
 * @author KH
 */
public class DBConnectionNotFoundException extends Exception{

    
    public DBConnectionNotFoundException() {
        super("Database connection not found!");
    }
    
    
}
