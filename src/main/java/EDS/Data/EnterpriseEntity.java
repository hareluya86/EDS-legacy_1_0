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
    
    /*
     * Test methods
     * - Not for production use!
     */
    public void randInit();
    
    public void setDATE_CREATED(java.sql.Date DATE_CREATED);
    public java.sql.Date getDATE_CREATED();
    
    public void setCREATED_BY(String CREATED_BY);
    public String getCREATED_BY();
    
    public void setDATE_CHANGED(java.sql.Date DATE_CHANGED);
    public java.sql.Date getDATE_CHANGED();
    
    public void setCHANGED_BY(String CHANGED_BY);
    public String getCHANGED_BY();
}
