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
@Table(name = "datastructure")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datastructure.findAll", query = "SELECT d FROM Datastructure d"),
    @NamedQuery(name = "Datastructure.findByAgencyid", query = "SELECT d FROM Datastructure d WHERE d.datastructurePK.agencyid = :agencyid"),
    @NamedQuery(name = "Datastructure.findById", query = "SELECT d FROM Datastructure d WHERE d.datastructurePK.id = :id"),
    @NamedQuery(name = "Datastructure.findByVersion", query = "SELECT d FROM Datastructure d WHERE d.datastructurePK.version = :version")})
public class Datastructure implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DatastructurePK datastructurePK;
    @JoinColumn(name = "annotations", referencedColumnName = "annotations")
    @OneToOne
    private Annotations annotations;
    @JoinColumn(name = "name", referencedColumnName = "name")
    @OneToOne
    private Name name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datastructure")
    private List<Datastructurecomponent> datastructurecomponentList;

    public Datastructure() {
    }

    public Datastructure(DatastructurePK datastructurePK) {
        this.datastructurePK = datastructurePK;
    }

    public Datastructure(String agencyid, String id, String version) {
        this.datastructurePK = new DatastructurePK(agencyid, id, version);
    }

    public DatastructurePK getDatastructurePK() {
        return datastructurePK;
    }

    public void setDatastructurePK(DatastructurePK datastructurePK) {
        this.datastructurePK = datastructurePK;
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

    @XmlTransient
    public List<Datastructurecomponent> getDatastructurecomponentList() {
        return datastructurecomponentList;
    }

    public void setDatastructurecomponentList(List<Datastructurecomponent> datastructurecomponentList) {
        this.datastructurecomponentList = datastructurecomponentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datastructurePK != null ? datastructurePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datastructure)) {
            return false;
        }
        Datastructure other = (Datastructure) object;
        if ((this.datastructurePK == null && other.datastructurePK != null) || (this.datastructurePK != null && !this.datastructurePK.equals(other.datastructurePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sdmx.gateway.entities.Datastructure[ datastructurePK=" + datastructurePK + " ]";
    }
    
}
