/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.BusinessUnit.Test;

import EDS.BusinessUnit.EnterpriseRelationshipId;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;

/**
 *
 * @author KH
 */
@Embeddable
@DiscriminatorValue("TESTRELATIONSHIPA")
public class TestRelationshipAId extends EnterpriseRelationshipId {
    
}
