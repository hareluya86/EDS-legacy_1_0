/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.Context;

/**
 *
 * @author KH
 */
public class ContextContainerStud implements ContextContainer {

    @Override
    public boolean allow() {
        return true;
    }

    @Override
    public Context getContext() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
