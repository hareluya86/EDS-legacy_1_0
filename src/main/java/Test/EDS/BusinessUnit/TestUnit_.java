/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test.EDS.BusinessUnit;

import EDS.BusinessUnit.EnterpriseUnit;
import EDS.BusinessUnit.EnterpriseUnit_;
import javax.persistence.metamodel.SingularAttribute;

/**
 *
 * @author KH
 */
public class TestUnit_ extends EnterpriseUnit_ {

    public static volatile SingularAttribute<EnterpriseUnit,String> TESTVARIABLE1;
    public static volatile SingularAttribute<EnterpriseUnit,String> TESTVARIABLE2;
}
