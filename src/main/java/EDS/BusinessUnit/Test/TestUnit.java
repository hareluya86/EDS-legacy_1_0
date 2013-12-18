/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.BusinessUnit.Test;

import EDS.BusinessUnit.EnterpriseRelationship;
import EDS.BusinessUnit.EnterpriseUnit;
import EDS.Data.EnterpriseKey;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.joda.time.DateTime;

/**
 *
 * @author KH
 */
@Entity
@Table(name="TESTUNIT")
@DiscriminatorValue("TESTUNIT")
public class TestUnit extends EnterpriseUnit {

    private String TESTVARIABLE1;
    private String TESTVARIABLE2;
    
    public TestUnit() {
    }

    public String getTESTVARIABLE1() {
        return TESTVARIABLE1;
    }

    public void setTESTVARIABLE1(String TESTVARIABLE1) {
        this.TESTVARIABLE1 = TESTVARIABLE1;
    }

    public String getTESTVARIABLE2() {
        return TESTVARIABLE2;
    }

    public void setTESTVARIABLE2(String TESTVARIABLE2) {
        this.TESTVARIABLE2 = TESTVARIABLE2;
    }
    
    @Transient
    @Override
    public EnterpriseKey enterpriseKey() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Transient
    @Override
    public String tableName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Transient
    @Override
    public String className() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Map<String, Object> exportAsMap() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String exportAsString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List exportAsList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void randInit() {
        DateTime today1 = new DateTime();
        DateTime tomorrow1 = today1.plusDays(1);
        java.sql.Date sqlDate1 = new java.sql.Date(today1.getMillis());
        java.sql.Date sqlDate2 = new java.sql.Date(tomorrow1.getMillis());
        int randInt = (int) (349204*Math.random());
        String var = "VARIABLE_";
        
        this.setSTART_DATE(sqlDate1);
        this.setEND_DATE(sqlDate2);
        this.setSHORT_NAME(var+randInt);
        this.setTESTVARIABLE1(TESTVARIABLE1);
        this.setTESTVARIABLE1(TESTVARIABLE2);
        
    }
    
}