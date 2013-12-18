/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.BusinessUnit;

import EDS.Data.EnterpriseEntity;
import EDS.Data.EnterpriseKey;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import org.joda.time.DateTime;

/**
 *
 * @author KH
 */
@Entity
@Table(name="ENTERPRISE_RELATIONSHIP")
@AssociationOverrides({
    @AssociationOverride(name="pk.SOURCE",joinColumns = @JoinColumn(name="SOURCE_ID")),
    @AssociationOverride(name="pk.TARGET",joinColumns = @JoinColumn(name="TARGET_ID"))
})
@Inheritance(strategy=InheritanceType.JOINED)
//@DiscriminatorColumn(name="REL_TYPE")
//@DiscriminatorValue("")
public abstract class EnterpriseRelationship implements EnterpriseEntity, EnterpriseKey {

    protected EnterpriseRelationshipId pk = new EnterpriseRelationshipId();
    
    private java.sql.Date LAST_CHANGED;
    private String CHANGED_BY;
    
    @EmbeddedId
    public EnterpriseRelationshipId getPk() {
        return pk;
    }

    public void setPk(EnterpriseRelationshipId pk) {
        this.pk = pk;
    }

    @Transient
    public EnterpriseUnit getTARGET() {
        return getPk().getTARGET();
    }

    public void setTARGET(EnterpriseUnit TARGET) {
        getPk().setTARGET(TARGET);
    }
    
    @Transient
    //@MapsId("SOURCE_ID")
    public EnterpriseUnit getSOURCE() {
        return getPk().getSOURCE();
    }

    public void setSOURCE(EnterpriseUnit SOURCE) {
        getPk().setSOURCE(SOURCE);
    }
    

    public String getCHANGED_BY() {
        return CHANGED_BY;
    }

    public void setCHANGED_BY(String CHANGED_BY) {
        this.CHANGED_BY = CHANGED_BY;
    }

    public Date getLAST_CHANGED() {
        return LAST_CHANGED;
    }

    public void setLAST_CHANGED(Date LAST_CHANGED) {
        this.LAST_CHANGED = LAST_CHANGED;
    }

    @Override
    public EnterpriseKey enterpriseKey() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void randInit() {
        DateTime today1 = new DateTime();
        java.sql.Date sqlDate1 = new java.sql.Date(today1.getMillis());
        int randInt = (int) (12345*Math.random());
        String var = "VARIABLE_";
        
        this.setCHANGED_BY(var+randInt);
        this.setLAST_CHANGED(sqlDate1);
    }

    @Override
    public String tableName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

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
}
