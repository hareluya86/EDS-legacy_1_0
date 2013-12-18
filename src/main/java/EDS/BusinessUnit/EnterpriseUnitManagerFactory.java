/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.BusinessUnit;

import EDS.BusinessUnit.Test.TestUnit;
import EDS.Context.ContextContainer;
import EDS.Exception.ContextNotAllowedException;
import EDS.Exception.EnterpriseObjectNotRecognized;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author KH
 */
public abstract class EnterpriseUnitManagerFactory {
    
    private static Map<String,EnterpriseUnit> units = new HashMap<String,EnterpriseUnit>();
    
    public static EnterpriseUnitManager getEnterpriseUnitManager(String name,ContextContainer cc) 
            throws ContextNotAllowedException, EnterpriseObjectNotRecognized{
        units.put("TestUnit", new TestUnit());
        if(!cc.allow()) throw new ContextNotAllowedException("To create EU "+name); //Contextual check
        if(!units.containsKey(name)) throw new EnterpriseObjectNotRecognized(name); //Name check
        
        EnterpriseUnitManager eum = new EnterpriseUnitManager();
        eum.setEu(units.get(name));
        return eum;
    }
}
