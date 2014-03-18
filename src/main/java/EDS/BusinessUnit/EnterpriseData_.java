/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EDS.BusinessUnit;

import javax.persistence.metamodel.SingularAttribute;

/**
 *
 * @author KH
 */
public class EnterpriseData_ {
    public static volatile SingularAttribute<EnterpriseData,EnterpriseUnit> BELONG_TO_OBJECT;
    public static volatile SingularAttribute<EnterpriseData,String> DATA_TYPE;
    public static volatile SingularAttribute<EnterpriseData,java.sql.Date> START_DATE;
    public static volatile SingularAttribute<EnterpriseData,java.sql.Date> END_DATE;
    public static volatile SingularAttribute<EnterpriseData,Long> SEQNUM;
    public static volatile SingularAttribute<EnterpriseData,Boolean> DATA_LOCK;
    public static volatile SingularAttribute<EnterpriseData,java.sql.Date> DATE_CREATED;
    public static volatile SingularAttribute<EnterpriseData,String> CREATED_BY;
    public static volatile SingularAttribute<EnterpriseData, java.sql.Date> DATE_CHANGED;
    public static volatile SingularAttribute<EnterpriseData,String> CHANGED_BY;
                                    
}
