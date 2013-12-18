/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.Data;


/**
 *
 * @author KH
 */
public interface EnterpriseEntity extends EnterpriseObject{
    
    public EnterpriseKey enterpriseKey();
    
    /*
     * Test methods
     * - Not for production use!
     */
    public void randInit();
}
