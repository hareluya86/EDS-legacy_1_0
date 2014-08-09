/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dropped.EDS.Data;


/**
 * An interface to represent an Entity from the Enterprise system for audit/
 * reporting purpose
 * <p>
 * Basic operations include:
 * - Finding the start and end periods of this entity
 * - Finding the creation and last changed date of this entity
 * - Finding the user who created and last edited this entity
 * - Populating this entity with test data (only used in the dev/test environment!)
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
