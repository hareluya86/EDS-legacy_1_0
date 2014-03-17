/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * An interface to represent a database object from the Enterprise System
 * <p>
 * 
 * @author KH
 */
public interface EnterpriseObject extends Serializable {
    
    /*
     * Name series
     * - tableName():String
     * The actual DB table name, in all caps
     * 
     * - className():String
     * The name of the java class representation
     */
    public String tableName();
    public String className();
    
    /*
     * Export series
     * - Map<String,Object>
     * Key as strings and any type of object as the value
     * 
     * - String
     * Concatenate all values in a pre-determined order and outputs as a string.
     * "Quick and dirty" way of comparing 2 objects of the same type
     * 
     * - List
     * Adds all values as objects into a list in a pre-determined order.
     * 
     */
    public Map<String,Object> exportAsMap();
    public String exportAsString();
    public List exportAsList();
    
    /*
     * Comparison series
     * - compareTo(EnterpriseObject obj): int
     * The Enterprise version of comparable interface
     * 
     * - equals(EnterpriseObject obj): boolean  
     * The Enterprise version of Object.equals method
     */
}
