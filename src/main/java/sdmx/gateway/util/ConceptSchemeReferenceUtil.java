/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.gateway.util;

import javax.persistence.EntityManager;
import sdmx.commonreferences.ConceptReference;
import sdmx.commonreferences.ConceptSchemeReference;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.ItemSchemeReferenceBase;
import sdmx.commonreferences.NestedNCNameID;
import sdmx.commonreferences.Version;


/**
 *
 * @author James
 */
public class ConceptSchemeReferenceUtil {

    public static sdmx.gateway.entities.Conceptschemereference toDatabaseConceptschemereference(EntityManager em, ConceptSchemeReference conceptIdentity) {
        sdmx.gateway.entities.Conceptschemereference ref = new sdmx.gateway.entities.Conceptschemereference();
        ref.setAgencyid(conceptIdentity.getAgencyId().toString());
        ref.setId(conceptIdentity.getMaintainableParentId().toString());
        ref.setVersion(conceptIdentity.getVersion().toString());
        em.persist(ref);
        return ref;
    }

    public static ItemSchemeReferenceBase toSDMXConceptSchemeReference(sdmx.gateway.entities.Conceptschemereference csr) {
        return ConceptSchemeReference.create(new NestedNCNameID(csr.getAgencyid()), new IDType(csr.getId()), new Version(csr.getVersion()));
    }
}
