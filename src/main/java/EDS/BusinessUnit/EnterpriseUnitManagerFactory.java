/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.BusinessUnit;

import EDS.BusinessUnit.Test.TestUnit;
import EDS.Context.ContextContainer;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author KH
 */
public abstract class EnterpriseUnitManagerFactory {
    
    private static Map<String,EnterpriseUnit> units = new HashMap<String,EnterpriseUnit>();
    
}
