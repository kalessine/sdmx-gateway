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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author james
 */
@Entity
@Table(name = "dataflow")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dataflow.findAll", query = "SELECT d FROM Dataflow d"),
    @NamedQuery(name = "Dataflow.findByDataflow", query = "SELECT d FROM Dataflow d WHERE d.dataflow = :dataflow"),
    @NamedQuery(name = "Dataflow.findByAgencyid", query = "SELECT d FROM Dataflow d WHERE d.agencyid = :agencyid"),
    @NamedQuery(name = "Dataflow.findById", query = "SELECT d FROM Dataflow d WHERE d.id = :id"),
    @NamedQuery(name = "Dataflow.findByVersion", query = "SELECT d FROM Dataflow d WHERE d.version = :version")})
public class Dataflow implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dataflow")
    private Long dataflow;
    @Size(max = 255)
    @Column(name = "agencyid")
    private String agencyid;
    @Size(max = 255)
    @Column(name = "id")
    private String id;
    @Size(max = 255)
    @Column(name = "version")
    private String version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dataflow1")
    private List<Observation> observationList;
    @JoinColumn(name = "annotations", referencedColumnName = "annotations")
    @OneToOne
    private Annotations annotations;
    @JoinColumn(name = "structure", referencedColumnName = "reference")
    @ManyToOne
    private Datastructurereference structure;
    @JoinColumn(name = "name", referencedColumnName = "name")
    @OneToOne
    private Name name;

    public Dataflow() {
    }

    public Dataflow(Long dataflow) {
        this.dataflow = dataflow;
    }

    public Long getDataflow() {
        return dataflow;
    }

    public void setDataflow(Long dataflow) {
        this.dataflow = dataflow;
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
    public List<Observation> getObservationList() {
        return observationList;
    }

    public void setObservationList(List<Observation> observationList) {
        this.observationList = observationList;
    }

    public Annotations getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Annotations annotations) {
        this.annotations = annotations;
    }

    public Datastructurereference getStructure() {
        return structure;
    }

    public void setStructure(Datastructurereference structure) {
        this.structure = structure;
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
        hash += (dataflow != null ? dataflow.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dataflow)) {
            return false;
        }
        Dataflow other = (Dataflow) object;
        if ((this.dataflow == null && other.dataflow != null) || (this.dataflow != null && !this.dataflow.equals(other.dataflow))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sdmx.gateway.entities.Dataflow[ dataflow=" + dataflow + " ]";
    }
    
}
