/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.BusinessUnit;

import java.util.Map;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 *
 * @author KH
 */
@StaticMetamodel(EnterpriseUnit.class)
public abstract class EnterpriseUnit_ {
    public static volatile SingularAttribute<EnterpriseUnit,Long> OBJECTID;
    //public static volatile SingularAttribute<EnterpriseUnit,String> OBJECT_TYPE;
    public static volatile SingularAttribute<EnterpriseUnit,java.sql.Date> START_DATE;
    public static volatile SingularAttribute<EnterpriseUnit,java.sql.Date> END_DATE;
    public static volatile SingularAttribute<EnterpriseUnit,java.sql.Date> DATE_CREATED;
    public static volatile SingularAttribute<EnterpriseUnit,String> CREATED__BY;
    public static volatile SingularAttribute<EnterpriseUnit,java.sql.Date> DATE_CHANGED;
    public static volatile SingularAttribute<EnterpriseUnit,String> CHANGED__BY;
    public static volatile SingularAttribute<EnterpriseUnit,String> SEARCH_TERM;
    public static volatile SingularAttribute<EnterpriseUnit,String> SHORT_NAME;
     
    //if metamodel is abstract, no concrete name method
    public abstract String name();
    
    /**
     * pathName():String
     * - returns "EnterpriseUnit/ExampleUnit"
     * - no idea what it would be used for yet
     */
    public abstract String pathName();
    
    /**
     * Returns a map object of <Field,FieldType>
     * <p>
     * 
     * 
     * @return Map  A map object of <Field,FieldType>
     */
    public abstract Map<String,Class> exportAsMap();
}
