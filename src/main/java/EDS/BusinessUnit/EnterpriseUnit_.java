/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.BusinessUnit;

import java.util.Map;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 *
 * @author KH
 */
@StaticMetamodel(EnterpriseUnit.class)
public class EnterpriseUnit_ {
    public static volatile SingularAttribute<EnterpriseUnit,Long> OBJECTID;
    public static volatile SingularAttribute<EnterpriseUnit,String> UNIT_TYPE;
    public static volatile SingularAttribute<EnterpriseUnit,java.sql.Date> START_DATE;
    public static volatile SingularAttribute<EnterpriseUnit,java.sql.Date> END_DATE;
    public static volatile SingularAttribute<EnterpriseUnit,java.sql.Date> DATE_CREATED;
    public static volatile SingularAttribute<EnterpriseUnit,String> CREATED_BY;
    public static volatile SingularAttribute<EnterpriseUnit,java.sql.Date> DATE_CHANGED;
    public static volatile SingularAttribute<EnterpriseUnit,String> CHANGED_BY;
    public static volatile SingularAttribute<EnterpriseUnit,String> SEARCH_TERM;
    public static volatile SingularAttribute<EnterpriseUnit,String> SHORT_NAME;
    
    public static volatile ListAttribute<EnterpriseUnit,EnterpriseRelationship> toRelationships;
    public static volatile ListAttribute<EnterpriseUnit,EnterpriseData> data;
}
