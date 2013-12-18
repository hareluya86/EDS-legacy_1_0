/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.Context;

/**
 *
 * @author KH
 */
public interface ContextContainer {
    
    /*
     * Returns a boolean to indicate if operation is allowed in context
     */
    public boolean allow();

    /*
     * Returns a context object to provide information about the current operating context
     */
    public Context getContext();
}
