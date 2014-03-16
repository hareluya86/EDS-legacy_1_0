/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.BusinessUnit;

import EDS.Data.EnterpriseEntity;
import EDS.Data.EnterpriseKey;
import java.sql.Date;
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
@EntityListeners(DateCreatedListener.class)
@AssociationOverrides({
    @AssociationOverride(name="pk.SOURCE",joinColumns = @JoinColumn(name="SOURCE_ID")),
    @AssociationOverride(name="pk.TARGET",joinColumns = @JoinColumn(name="TARGET_ID"))
})
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="REL_TYPE")
//@DiscriminatorValue("")
public abstract class EnterpriseRelationship implements EnterpriseEntity, EnterpriseKey {

    protected EnterpriseRelationshipId pk = new EnterpriseRelationshipId();
    
    private java.sql.Date DATE_CHANGED;
    private String CHANGED_BY;
    
    private java.sql.Date DATE_CREATED;
    private String CREATED_BY;
    
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
    

    @Override
    public String getCHANGED_BY() {
        return CHANGED_BY;
    }

    @Override
    public void setCHANGED_BY(String CHANGED_BY) {
        this.CHANGED_BY = CHANGED_BY;
    }

    @Override
    public Date getDATE_CHANGED() {
        return DATE_CHANGED;
    }

    @Override
    public void setDATE_CHANGED(java.sql.Date DATE_CHANGED) {
        this.DATE_CHANGED = DATE_CHANGED;
    }
    
    @Override
    public void setDATE_CREATED(java.sql.Date DATE_CREATED) {
        this.DATE_CREATED = DATE_CREATED;
    }

    @Override
    public java.sql.Date getDATE_CREATED() {
        return DATE_CREATED;
    }

    @Override
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY; 
    }

    @Override
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    @Override
    public Object key() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void randInit() {
        DateTime today1 = new DateTime();
        java.sql.Date sqlDate1 = new java.sql.Date(today1.getMillis());
        int randInt = (int) (12345*Math.random());
        String var = "VARIABLE_";
        
        this.setCHANGED_BY(var+randInt);
        this.setDATE_CHANGED(sqlDate1);
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
