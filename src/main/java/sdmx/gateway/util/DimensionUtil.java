/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.gateway.util;

import javax.persistence.EntityManager;
import sdmx.structure.base.Component;
import sdmx.structure.base.RepresentationType;
import sdmx.structure.datastructure.AttributeType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.structure.datastructure.DimensionType;
import sdmx.structure.datastructure.MeasureDimensionType;
import sdmx.structure.datastructure.PrimaryMeasure;
import sdmx.structure.datastructure.SimpleDataStructureRepresentationType;
import sdmx.structure.datastructure.TimeDimensionType;

/**
 *
 * @author James
 */
public class DimensionUtil {

    public static final int TYPE_DIMENSION = 0;
    public static final int TYPE_TIMEDIMENSION = 1;
    public static final int TYPE_MEASURE = 2;
    public static final int TYPE_PRIMARYMEASURE = 3;
    public static final int TYPE_ATTRIBUTE = 4;

    public static sdmx.gateway.entities.Datastructurecomponent toDatabaseDimension(EntityManager em, DataStructureType struct, Component c, int position) {
        sdmx.gateway.entities.Datastructurecomponent dsc = new sdmx.gateway.entities.Datastructurecomponent();
        sdmx.gateway.entities.DatastructurecomponentPK pk = new sdmx.gateway.entities.DatastructurecomponentPK();
        pk.setAgencyid(struct.getAgencyID().toString());
        pk.setId(struct.getId().toString());
        pk.setVersion(struct.getVersion().toString());
        pk.setPosition((short)position);
        dsc.setDatastructurecomponentPK(pk);
        dsc.setConceptidentity(ConceptReferenceUtil.toDatabaseConceptreference(em, c.getConceptIdentity()));
        dsc.setComponentid(c.getId().toString());
        //dsc.setConceptReference(ConceptReferenceUtil.toDatabaseConceptreference(em, c.getConceptIdentity()));
        if (c instanceof MeasureDimensionType) {
            MeasureDimensionType dim = (MeasureDimensionType) c;
            dsc.setType(TYPE_MEASURE);
            RepresentationType rep = dim.getLocalRepresentation();
            if (rep == null) {
                // Get Concept Representation
            }
            if (rep != null && rep.getEnumeration() != null) {
                //dsc.setConceptSchemeReference(ConceptSchemeReferenceUtil.toDatabaseConceptschemereference(em, rep.getEnumeration().asConceptSchemeReference()));
                dsc.setConceptschemeenumeration(ConceptSchemeReferenceUtil.toDatabaseConceptschemereference(em, rep.getEnumeration().asConceptSchemeReference()));
            }
        } else if (c instanceof DimensionType) {
            DimensionType dim = (DimensionType) c;
            dsc.setType(TYPE_DIMENSION);
            RepresentationType rep = dim.getLocalRepresentation();
            if (rep == null) {
                // Get Concept Representation
            }
            if (rep != null && rep.getEnumeration() != null) {
                dsc.setCodelistenumeration(CodelistReferenceUtil.toDatabaseCodelistReference(em, rep.getEnumeration().asCodelistReference()));
                //dsc.setCodelistReference(CodelistReferenceUtil.toDatabaseCodelistReference(em, rep.getEnumeration().asCodelistReference()));
            }
        } else if (c instanceof TimeDimensionType) {
            dsc.setType(TYPE_TIMEDIMENSION);
            TimeDimensionType dim = (TimeDimensionType) c;
            RepresentationType rep = dim.getLocalRepresentation();
            if (rep == null) {
                // Get Concept Representation
            }
            if (rep != null && rep.getEnumeration() != null) {
                dsc.setCodelistenumeration(CodelistReferenceUtil.toDatabaseCodelistReference(em, rep.getEnumeration().asCodelistReference()));
                //dsc.setCodelistReference(CodelistReferenceUtil.toDatabaseCodelistReference(em, rep.getEnumeration().asCodelistReference()));
            }
        } else if (c instanceof AttributeType) {
            dsc.setType(TYPE_ATTRIBUTE);
            AttributeType dim = (AttributeType) c;
            RepresentationType rep = dim.getLocalRepresentation();
            if (rep == null) {
                // Get Concept Representation
            }
            if (rep != null && rep.getEnumeration() != null) {
                //dsc.setCodelistReference(CodelistReferenceUtil.toDatabaseCodelistReference(em, rep.getEnumeration().asCodelistReference()));
                dsc.setCodelistenumeration(CodelistReferenceUtil.toDatabaseCodelistReference(em, rep.getEnumeration().asCodelistReference()));
            }
        } else if (c instanceof PrimaryMeasure) {
            PrimaryMeasure dim = (PrimaryMeasure) c;
            dsc.setType(TYPE_PRIMARYMEASURE);
            RepresentationType rep = dim.getLocalRepresentation();
            if (rep == null) {
                // Get Concept Representation
            }
            if (rep != null && rep.getEnumeration() != null) {
                dsc.setCodelistenumeration(CodelistReferenceUtil.toDatabaseCodelistReference(em, rep.getEnumeration().asCodelistReference()));
                //dsc.setCodelistReference(CodelistReferenceUtil.toDatabaseCodelistReference(em, rep.getEnumeration().asCodelistReference()));
            }
        }
        return dsc;

    }

    public static Component toSDMXDimension(sdmx.gateway.entities.Datastructurecomponent dc) {
        Component comp = null;
        switch (dc.getType()) {
            case DimensionUtil.TYPE_DIMENSION:
                comp = new DimensionType();
                break;
            case DimensionUtil.TYPE_ATTRIBUTE:
                comp = new AttributeType();
                break;
            case DimensionUtil.TYPE_TIMEDIMENSION:
                comp = new TimeDimensionType();
                break;
            case DimensionUtil.TYPE_MEASURE:
                comp = new MeasureDimensionType();
                break;
            case DimensionUtil.TYPE_PRIMARYMEASURE:
                comp = new PrimaryMeasure();
                break;
        }
        comp.setConceptIdentity(ConceptReferenceUtil.toSDMXReference(dc.getConceptidentity()));
        //comp.setConceptIdentity(ConceptReferenceUtil.toSDMXReference(dc.getConceptReference()));
        RepresentationType lr = new SimpleDataStructureRepresentationType();
         if (dc.getCodelistenumeration() != null) {
            lr.setEnumeration(CodelistReferenceUtil.toSDMXCodelistReference(dc.getCodelistenumeration()));
        }
        if (dc.getConceptschemeenumeration() != null) {
            lr.setEnumeration(ConceptSchemeReferenceUtil.toSDMXConceptSchemeReference(dc.getConceptschemeenumeration()));
        }
        /*
       
        if (dc.getCodelistReference() != null) {
            lr.setEnumeration(CodelistReferenceUtil.toSDMXCodelistReference(dc.getCodelistReference()));
        }
        if (dc.getConceptSchemeReference()!= null) {
            lr.setEnumeration(ConceptSchemeReferenceUtil.toSDMXConceptSchemeReference(dc.getConceptSchemeReference()));
        }*/
        comp.setLocalRepresentation(lr);
        return comp;
    }
}
