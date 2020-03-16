/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.gateway.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author james
 */
@Entity
@Table(name = "conceptschemereference")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conceptschemereference.findAll", query = "SELECT c FROM Conceptschemereference c"),
    @NamedQuery(name = "Conceptschemereference.findByReference", query = "SELECT c FROM Conceptschemereference c WHERE c.reference = :reference"),
    @NamedQuery(name = "Conceptschemereference.findByAgencyid", query = "SELECT c FROM Conceptschemereference c WHERE c.agencyid = :agencyid"),
    @NamedQuery(name = "Conceptschemereference.findById", query = "SELECT c FROM Conceptschemereference c WHERE c.id = :id"),
    @NamedQuery(name = "Conceptschemereference.findByVersion", query = "SELECT c FROM Conceptschemereference c WHERE c.version = :version")})
public class Conceptschemereference implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reference")
    private Long reference;
    @Size(max = 255)
    @Column(name = "agencyid")
    private String agencyid;
    @Size(max = 255)
    @Column(name = "id")
    private String id;
    @Size(max = 255)
    @Column(name = "version")
    private String version;
    @OneToOne(mappedBy = "conceptschemeenumeration")
    private Datastructurecomponent datastructurecomponent;

    public Conceptschemereference() {
    }

    public Conceptschemereference(Long reference) {
        this.reference = reference;
    }

    public Long getReference() {
        return reference;
    }

    public void setReference(Long reference) {
        this.reference = reference;
    }

    public String getAgencyid() {
        return agencyid;
    }

    public void setAgencyid(String agencyid) {
        this.agencyid = agencyid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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
        hash += (reference != null ? reference.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conceptschemereference)) {
            return false;
        }
        Conceptschemereference other = (Conceptschemereference) object;
        if ((this.reference == null && other.reference != null) || (this.reference != null && !this.reference.equals(other.reference))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sdmx.gateway.entities.Conceptschemereference[ reference=" + reference + " ]";
    }
    
}
