/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.gateway.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author james
 */
@Entity
@Table(name = "datastructurereference")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datastructurereference.findAll", query = "SELECT d FROM Datastructurereference d"),
    @NamedQuery(name = "Datastructurereference.findByReference", query = "SELECT d FROM Datastructurereference d WHERE d.reference = :reference"),
    @NamedQuery(name = "Datastructurereference.findByAgencyid", query = "SELECT d FROM Datastructurereference d WHERE d.agencyid = :agencyid"),
    @NamedQuery(name = "Datastructurereference.findById", query = "SELECT d FROM Datastructurereference d WHERE d.id = :id"),
    @NamedQuery(name = "Datastructurereference.findByVersion", query = "SELECT d FROM Datastructurereference d WHERE d.version = :version")})
public class Datastructurereference implements Serializable {

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
    @OneToMany(mappedBy = "structure")
    private List<Dataflow> dataflowList;

    public Datastructurereference() {
    }

    public Datastructurereference(Long reference) {
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

    @XmlTransient
    public List<Dataflow> getDataflowList() {
        return dataflowList;
    }

    public void setDataflowList(List<Dataflow> dataflowList) {
        this.dataflowList = dataflowList;
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
        if (!(object instanceof Datastructurereference)) {
            return false;
        }
        Datastructurereference other = (Datastructurereference) object;
        if ((this.reference == null && other.reference != null) || (this.reference != null && !this.reference.equals(other.reference))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sdmx.gateway.entities.Datastructurereference[ reference=" + reference + " ]";
    }
    
}
