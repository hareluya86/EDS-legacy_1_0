/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.BusinessUnit;

import EDS.Data.EnterpriseEntity;
import EDS.Data.EnterpriseKey;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.*;

/**
 *
 * @author KH
 */
@Entity
@Table(name="ENTERPRISEUNIT")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="UNIT_TYPE")
@TableGenerator(name="ENTERPRISEUNIT_SEQ",initialValue=1,allocationSize=10,table="SEQUENCE")
public abstract class EnterpriseUnit implements EnterpriseEntity, EnterpriseKey{
    
    protected long OBJECTID;
    protected String UNIT_TYPE;
    /*
     * Start and End dates should not be primary keys
     * - Only 1 instance of an entity should exist anytime
     * - If both start and end dates are PK, this means >1 record can be created
     * for 1 object id.
     */
    /*@Id*/ protected java.sql.Date START_DATE;
    /*@Id*/ protected java.sql.Date END_DATE;
    
    protected java.sql.Date DATE_CREATED;
    protected String CREATED_BY;
    
    protected java.sql.Date DATE_CHANGED;
    protected String CHANGED_BY;
    
    protected String SEARCH_TERM;
    protected String SHORT_NAME;

    protected List<EnterpriseRelationship> toRelationships = new ArrayList<EnterpriseRelationship>();
    
    public String getCHANGED_BY() {
        return CHANGED_BY;
    }

    public void setCHANGED_BY(String CHANGED_BY) {
        this.CHANGED_BY = CHANGED_BY;
    }

    public String getCREATED_BY() {
        return CREATED_BY;
    }

    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY;
    }

    public Date getDATE_CHANGED() {
        return DATE_CHANGED;
    }

    public void setDATE_CHANGED(Date DATE_CHANGED) {
        this.DATE_CHANGED = DATE_CHANGED;
    }

    public Date getDATE_CREATED() {
        return DATE_CREATED;
    }

    public void setDATE_CREATED(Date DATE_CREATED) {
        this.DATE_CREATED = DATE_CREATED;
    }
 
    @Id @GeneratedValue(generator="ENTERPRISEUNIT_SEQ",strategy=GenerationType.TABLE) 
    public long getOBJECTID() {
        return OBJECTID;
    }

    public void setOBJECTID(long OBJECTID) {
        this.OBJECTID = OBJECTID;
    }

    @OneToMany(fetch=FetchType.LAZY,mappedBy="pk.SOURCE")
    public List<EnterpriseRelationship> getToRelationships(){
        return this.toRelationships;
    }
    
    public void setToRelationships(List<EnterpriseRelationship> toRelationships){
        this.toRelationships = toRelationships;
    }

    public Date getEND_DATE() {
        return END_DATE;
    }

    public void setEND_DATE(Date END_DATE) {
        this.END_DATE = END_DATE;
    }

    public String getSEARCH_TERM() {
        return SEARCH_TERM;
    }

    public void setSEARCH_TERM(String SEARCH_TERM) {
        this.SEARCH_TERM = SEARCH_TERM;
    }

    public String getSHORT_NAME() {
        return SHORT_NAME;
    }

    public void setSHORT_NAME(String SHORT_NAME) {
        this.SHORT_NAME = SHORT_NAME;
    }

    public Date getSTART_DATE() {
        return START_DATE;
    }

    public void setSTART_DATE(Date START_DATE) {
        this.START_DATE = START_DATE;
    }
    
    public void addRelationship(EnterpriseRelationship rel){
        this.toRelationships.add(rel);
    }

    /**
     * This is to allow front-end components to access all of the fields in each
     * EnterpriseUnit implementation. 
     * @return Map  A collection of <Field,Value>
     */
    @Override
    public abstract Map<String, Object> exportAsMap();
    
    
}