/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.Data;

/**
 *
 * @author KH
 */
public interface EnterpriseTransaction {
    
    public void start();
    public void commit();
    public void rollback();
}
