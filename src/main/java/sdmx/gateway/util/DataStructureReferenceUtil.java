/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.gateway.util;

import javax.persistence.EntityManager;
import sdmx.commonreferences.ConceptReference;
import sdmx.commonreferences.ConceptSchemeReference;
import sdmx.commonreferences.DataStructureReference;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.ItemSchemeReferenceBase;
import sdmx.commonreferences.NestedNCNameID;
import sdmx.commonreferences.Version;

/**
 *
 * @author James
 */
public class DataStructureReferenceUtil {

    public static sdmx.gateway.entities.Datastructurereference toDatabaseDataStructureReference(EntityManager em, DataStructureReference reference) {
        sdmx.gateway.entities.Datastructurereference ref = new sdmx.gateway.entities.Datastructurereference();
        ref.setAgencyid(reference.getAgencyId().toString());
        ref.setId(reference.getMaintainableParentId().toString());
        ref.setVersion(reference.getVersion().toString());
        return ref;

    }
    public static sdmx.gateway.entities.Datastructurereference toDatabaseDataStructureReference(EntityManager em, sdmx.gateway.entities.Datastructure struct) {
        sdmx.gateway.entities.Datastructurereference ref = new sdmx.gateway.entities.Datastructurereference();
         ref.setAgencyid(struct.getDatastructurePK().getAgencyid().toString());
         ref.setId(struct.getDatastructurePK().getId().toString());
         ref.setVersion(struct.getDatastructurePK().getVersion().toString());
         return ref;
    }

    public static DataStructureReference toSDMXDataStructureReference(sdmx.gateway.entities.Datastructurereference ref) {
        return DataStructureReference.create(new NestedNCNameID(ref.getAgencyid()),new IDType(ref.getId()), new Version(ref.getVersion()));
    }
}
