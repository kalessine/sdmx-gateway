/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.gateway.util;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import sdmx.common.AnnotationType;
import sdmx.common.Annotations;
import sdmx.common.TextType;
import sdmx.gateway.entities.Annotation;
import sdmx.gateway.entities.Annotationtext;

/**
 *
 * @author James
 */
public class AnnotationsUtil {

    public static sdmx.gateway.entities.Annotations toDatabaseAnnotations(EntityManager em,Annotations annots) {
        if (annots == null) {
            return null;
        }
        sdmx.gateway.entities.Annotations at = new sdmx.gateway.entities.Annotations();
        em.persist(at);
        em.flush();
        em.refresh(at);
        List<sdmx.gateway.entities.Annotation> dbAnnots = new ArrayList<>(annots.size());
        for (int i = 0; i < annots.size(); i++) {
            Annotation an = toDatabaseAnnotation(at, annots.getAnnotation(i));
            if (an != null) {
                an.getAnnotationPK().setAnnotations(at.getAnnotations());
                an.getAnnotationPK().setIndex((short) dbAnnots.size());
                dbAnnots.add(an);
            }
        }
        at.setAnnotationList(dbAnnots);
        em.merge(at);
        return at;
    }

    public static sdmx.gateway.entities.Annotation toDatabaseAnnotation(sdmx.gateway.entities.Annotations at, AnnotationType annot) {
        if (annot == null) {
            return null;
        }
        sdmx.gateway.entities.Annotation dbAnnot = new sdmx.gateway.entities.Annotation();
        sdmx.gateway.entities.AnnotationPK pk = new sdmx.gateway.entities.AnnotationPK();
        dbAnnot.setAnnotationPK(pk);
        dbAnnot.setAnnotations1(at);
        dbAnnot.setTitle(annot.getAnnotationTitle());
        dbAnnot.setAnnotationid(annot.getId());
        dbAnnot.setType(annot.getAnnotationType());
        dbAnnot.setUrl(annot.getAnnotationUrl());
        List<sdmx.gateway.entities.Annotationtext> texts = new ArrayList<>();
        for (int i = 0; i < annot.getAnnotationText().size(); i++) {
            if (annot.getAnnotationText() != null) {
                sdmx.gateway.entities.Annotationtext att = toDatabaseAnnotationText(annot.getAnnotationText().get(i));
                sdmx.gateway.entities.AnnotationtextPK pk2 = new sdmx.gateway.entities.AnnotationtextPK();
                pk2.setTextindex((short) texts.size());
                att.setAnnotationtextPK(pk2);
                texts.add(att);
            }
        }
        return dbAnnot;
    }

    public static sdmx.gateway.entities.Annotationtext toDatabaseAnnotationText(TextType tt) {
        sdmx.gateway.entities.Annotationtext at = new sdmx.gateway.entities.Annotationtext();
        at.setText(tt.getText());
        at.setLang(tt.getLang());
        return at;
    }

    public static Annotations toSDMXAnnotations(sdmx.gateway.entities.Annotations annot) {
        if (annot == null) {
            return null;
        }
        Annotations annotations = new Annotations();
        List<sdmx.gateway.entities.Annotation> annots = annot.getAnnotationList();
        for (sdmx.gateway.entities.Annotation an : annots) {
            annotations.addAnnotation(toSDMXAnnotation(an));
        }
        return annotations;
    }

    public static sdmx.common.AnnotationType toSDMXAnnotation(sdmx.gateway.entities.Annotation an) {
        AnnotationType annot = new AnnotationType();
        annot.setAnnotationTitle(an.getTitle());
        annot.setAnnotationType(an.getType());
        annot.setAnnotationUrl(an.getUrl());
        for (Annotationtext text : an.getAnnotationtextList()) {
            annot.addAnnotationText(new TextType(text.getLang(), text.getText()));
        }
        return annot;
    }
}
