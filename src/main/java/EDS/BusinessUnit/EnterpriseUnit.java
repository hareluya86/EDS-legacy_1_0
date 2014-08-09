/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.BusinessUnit;

import Dropped.EDS.Data.EnterpriseEntity;
import Dropped.EDS.Data.EnterpriseKey;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.*;

/**
 *
 * @author KH
 */
@Entity
@Table(name="ENTERPRISEUNIT")
//@MappedSuperclass
@EntityListeners(DateCreatedListener.class)
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
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
    protected List<EnterpriseData> data = new ArrayList<EnterpriseData>();

    public String getUNIT_TYPE() {
        return UNIT_TYPE;
    }

    public void setUNIT_TYPE(String UNIT_TYPE) {
        this.UNIT_TYPE = UNIT_TYPE;
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
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    @Override
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY;
    }

    @Override
    public Date getDATE_CHANGED() {
        return DATE_CHANGED;
    }

    @Override
    public void setDATE_CHANGED(Date DATE_CHANGED) {
        this.DATE_CHANGED = DATE_CHANGED;
    }

    @Override
    public Date getDATE_CREATED() {
        return DATE_CREATED;
    }

    @Override
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

    
    @OneToMany(fetch=FetchType.LAZY)
    //@JoinColumn(name="BELONG_TO_OBJECT_OBJECTID")
    public List<EnterpriseData> getData() {
        return data;
    }

    public void setData(List<EnterpriseData> data) {
        this.data = data;
    }
    /**/

    /**
     * This is to allow front-end components to access all of the fields in each
     * EnterpriseUnit implementation. 
     * @return Map  A collection of <Field,Value>
     */
    @Override
    public Map<String, Object> exportAsMap(){
        Map<String, Object> map = new HashMap<String, Object>();
        
        map.put("OBJECTID", OBJECTID);
        map.put("UNIT_TYPE",UNIT_TYPE);
        map.put("START_DATE",START_DATE);
        map.put("END_DATE",END_DATE);
        map.put("DATE_CREATED",DATE_CREATED);
        map.put("CREATED_BY",CREATED_BY);
        map.put("DATE_CHANGED",DATE_CHANGED);
        map.put("CHANGED_BY",CHANGED_BY);
        map.put("SEARCH_TERM",SEARCH_TERM);
        map.put("SHORT_NAME",SHORT_NAME);
        
        return map;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.OBJECTID ^ (this.OBJECTID >>> 32));
        hash = 97 * hash + (this.UNIT_TYPE != null ? this.UNIT_TYPE.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EnterpriseUnit other = (EnterpriseUnit) obj;
        if (this.OBJECTID != other.OBJECTID) {
            return false;
        }
        if ((this.UNIT_TYPE == null) ? (other.UNIT_TYPE != null) : !this.UNIT_TYPE.equals(other.UNIT_TYPE)) {
            return false;
        }
        return true;
    }
    
    
}