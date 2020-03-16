/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.gateway.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "conceptscheme")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conceptscheme.findAll", query = "SELECT c FROM Conceptscheme c"),
    @NamedQuery(name = "Conceptscheme.findByAgencyid", query = "SELECT c FROM Conceptscheme c WHERE c.conceptschemePK.agencyid = :agencyid"),
    @NamedQuery(name = "Conceptscheme.findById", query = "SELECT c FROM Conceptscheme c WHERE c.conceptschemePK.id = :id"),
    @NamedQuery(name = "Conceptscheme.findByVersion", query = "SELECT c FROM Conceptscheme c WHERE c.conceptschemePK.version = :version")})
public class Conceptscheme implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConceptschemePK conceptschemePK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conceptscheme")
    private List<Concept> conceptList;
    @JoinColumn(name = "annotations", referencedColumnName = "annotations")
    @OneToOne
    private Annotations annotations;
    @JoinColumn(name = "name", referencedColumnName = "name")
    @OneToOne
    private Name name;

    public Conceptscheme() {
    }

    public Conceptscheme(ConceptschemePK conceptschemePK) {
        this.conceptschemePK = conceptschemePK;
    }

    public Conceptscheme(String agencyid, String id, String version) {
        this.conceptschemePK = new ConceptschemePK(agencyid, id, version);
    }

    public ConceptschemePK getConceptschemePK() {
        return conceptschemePK;
    }

    public void setConceptschemePK(ConceptschemePK conceptschemePK) {
        this.conceptschemePK = conceptschemePK;
    }

    @XmlTransient
    public List<Concept> getConceptList() {
        return conceptList;
    }

    public void setConceptList(List<Concept> conceptList) {
        this.conceptList = conceptList;
    }

    public Annotations getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Annotations annotations) {
        this.annotations = annotations;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conceptschemePK != null ? conceptschemePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conceptscheme)) {
            return false;
        }
        Conceptscheme other = (Conceptscheme) object;
        if ((this.conceptschemePK == null && other.conceptschemePK != null) || (this.conceptschemePK != null && !this.conceptschemePK.equals(other.conceptschemePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sdmx.gateway.entities.Conceptscheme[ conceptschemePK=" + conceptschemePK + " ]";
    }
    
}
