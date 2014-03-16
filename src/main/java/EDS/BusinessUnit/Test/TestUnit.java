/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.BusinessUnit.Test;

import EDS.BusinessUnit.EnterpriseUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.joda.time.DateTime;

/**
 *
 * @author KH
 */
@Entity
@Table(name="TESTUNIT")
@DiscriminatorValue("TESTUNIT")
public class TestUnit extends EnterpriseUnit {

    protected String TESTVARIABLE1;
    protected String TESTVARIABLE2;
    
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
    
    
    @Override //@Transient
    public Object key() {
        return this.OBJECTID;
    }

    //@Transient
    @Override
    public String tableName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //@Transient
    @Override
    public String className() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Map<String, Object> exportAsMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        
        map.put("OBJECTID", this.OBJECTID);
        map.put("START_DATE", this.START_DATE);
        map.put("END_DATE", this.END_DATE);
        map.put("CHANGED_BY", this.CHANGED_BY);
        map.put("DATE_CHANGED", this.DATE_CHANGED);
        map.put("CREATED_BY", this.CREATED_BY);
        map.put("DATE_CREATED", this.DATE_CREATED);
        map.put("SEARCH_TERM", this.SEARCH_TERM);
        map.put("SHORT_NAME", this.SHORT_NAME);
        map.put("TESTVARIABLE1", this.TESTVARIABLE1);
        map.put("TESTVARIABLE2", this.TESTVARIABLE2);
        map.put("UNIT_TYPE", this.UNIT_TYPE);
        
        return map;
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
