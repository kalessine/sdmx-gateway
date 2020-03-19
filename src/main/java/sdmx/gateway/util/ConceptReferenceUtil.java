/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.gateway.util;

import javax.persistence.EntityManager;
import sdmx.commonreferences.ConceptReference;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedNCNameID;
import sdmx.commonreferences.Version;

/**
 *
 * @author James
 */
public class ConceptReferenceUtil {

    public static sdmx.gateway.entities.Conceptreference toDatabaseConceptreference(EntityManager em, ConceptReference conceptIdentity) {
         sdmx.gateway.entities.Conceptreference ref = new sdmx.gateway.entities.Conceptreference();
         ref.setAgencyid(conceptIdentity.getAgencyId().toString());
         ref.setConceptid(conceptIdentity.getId().toString());
         ref.setId(conceptIdentity.getMaintainableParentId().toString());
         ref.setVersion(conceptIdentity.getVersion().toString());
         em.persist(ref);
         return ref;

    }
    public static ConceptReference toSDMXReference(sdmx.gateway.entities.Conceptreference con) {
        ConceptReference ref = ConceptReference.create(new NestedNCNameID(con.getAgencyid()), new IDType(con.getId()), new Version(con.getVersion()), new IDType(con.getConceptid()));
        return ref;
    }

}
