/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.Data;

import EDS.BusinessUnit.EnterpriseUnit;
import java.util.Collection;

/**
 *
 * @author KH
 */
public abstract class DAO {
    
    /*
     * Test methods in the development phase
     */
    public abstract EnterpriseEntity getSingleObject(EnterpriseKey key);
    public abstract Collection<EnterpriseEntity> getManyObjects(Collection<EnterpriseKey> keys);
    
    public abstract void insertSingleObject(EnterpriseEntity row);
    public abstract void insertManyObjects(Collection<EnterpriseEntity> objects);
    
    public abstract void deleteSingleObject(EnterpriseKey key);
    public abstract void deleteManyObjects(Collection<EnterpriseKey> keys);
    /*
     * Test methods in the development phase
     */
    
}
