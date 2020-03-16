/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.gateway.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author james
 */
@Entity
@Table(name = "annotations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Annotations.findAll", query = "SELECT a FROM Annotations a"),
    @NamedQuery(name = "Annotations.findByAnnotations", query = "SELECT a FROM Annotations a WHERE a.annotations = :annotations"),
    @NamedQuery(name = "Annotations.findByDummyfield", query = "SELECT a FROM Annotations a WHERE a.dummyfield = :dummyfield")})
public class Annotations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "annotations")
    private Long annotations;
    @Column(name = "dummyfield")
    private Short dummyfield;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "annotations1")
    private List<Annotation> annotationList;
    @OneToOne(mappedBy = "annotations")
    private Code code;
    @OneToOne(mappedBy = "annotations")
    private Codelist codelist;
    @OneToOne(mappedBy = "annotations")
    private Concept concept;
    @OneToOne(mappedBy = "annotations")
    private Dataflow dataflow;
    @OneToOne(mappedBy = "annotations")
    private Conceptscheme conceptscheme;
    @OneToOne(mappedBy = "annotations")
    private Datastructure datastructure;
    @OneToOne(mappedBy = "annotations")
    private Datastructurecomponent datastructurecomponent;

    public Annotations() {
    }

    public Annotations(Long annotations) {
        this.annotations = annotations;
    }

    public Long getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Long annotations) {
        this.annotations = annotations;
    }

    public Short getDummyfield() {
        return dummyfield;
    }

    public void setDummyfield(Short dummyfield) {
        this.dummyfield = dummyfield;
    }

    @XmlTransient
    public List<Annotation> getAnnotationList() {
        return annotationList;
    }

    public void setAnnotationList(List<Annotation> annotationList) {
        this.annotationList = annotationList;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public Codelist getCodelist() {
        return codelist;
    }

    public void setCodelist(Codelist codelist) {
        this.codelist = codelist;
    }

    public Concept getConcept() {
        return concept;
    }

    public void setConcept(Concept concept) {
        this.concept = concept;
    }

    public Dataflow getDataflow() {
        return dataflow;
    }

    public void setDataflow(Dataflow dataflow) {
        this.dataflow = dataflow;
    }

    public Conceptscheme getConceptscheme() {
        return conceptscheme;
    }

    public void setConceptscheme(Conceptscheme conceptscheme) {
        this.conceptscheme = conceptscheme;
    }

    public Datastructure getDatastructure() {
        return datastructure;
    }

    public void setDatastructure(Datastructure datastructure) {
        this.datastructure = datastructure;
    }

    public Datastructurecomponent getDatastructurecomponent() {
        return datastructurecomponent;
    }

    public void setDatastructurecomponent(Datastructurecomponent datastructurecomponent) {
        this.datastructurecomponent = datastructurecomponent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (annotations != null ? annotations.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Annotations)) {
            return false;
        }
        Annotations other = (Annotations) object;
        if ((this.annotations == null && other.annotations != null) || (this.annotations != null && !this.annotations.equals(other.annotations))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sdmx.gateway.entities.Annotations[ annotations=" + annotations + " ]";
    }
    
}
